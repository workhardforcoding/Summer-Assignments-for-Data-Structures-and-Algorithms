import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class MingruoHW {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Java\\java_code\\src";
        for (int i = 1; i <= 10; i++) {
            fileIO(filePath, i);
        }
    }

    private static void fileIO(String filePath, int fileName) throws IOException {
        File file = new File(filePath + "\\" + fileName + ".in");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
//        System.out.println(n);
        int[][] src = new int[n][2];

        for (int i = 0; i < n; i++) {
//            System.out.println(sc.nextInt());
//            System.out.println(sc.nextInt());
            src[i][0] = sc.nextInt();
            src[i][1] = sc.nextInt();
        }

        int ans = new Solution1().totalProgram(src);
        System.out.println(ans);
        File output = new File(filePath + "\\" + fileName + ".out");
        Files.write(Paths.get(filePath + "\\" + fileName + ".out"), (ans + "").getBytes());
    }
}

class Solution1 {
    public int totalProgram(int[][] src) {
        Arrays.sort(src, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int n = src.length;
        int deleteFirst = src[n - 1][1] - src[1][0];
        int deleteLast = src[n - 2][1] - src[0][0];
        return (deleteFirst < deleteLast ? deleteFirst : deleteLast) + 1;
    }
}