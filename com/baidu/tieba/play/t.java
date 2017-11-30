package com.baidu.tieba.play;

import android.os.Environment;
import com.baidu.adp.lib.util.StringUtils;
import java.io.File;
/* loaded from: classes.dex */
public class t {
    public static final String bbp = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String bbq = bbp + "/.tieba_video_cache";
    public static final String bbr = bbq + "/v2";
    public static final String bbs = bbr + "/";
    public static final String bbt = bbr + "/files";
    public static final String bbu = bbt + "/";

    private static long hB(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(bbu + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String hC(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long rr(String str) {
        try {
            String hC = hC(str);
            if (StringUtils.isNULL(hC)) {
                return 0L;
            }
            return hB(hC);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
