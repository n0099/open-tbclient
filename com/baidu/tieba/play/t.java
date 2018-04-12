package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class t {
    public static final String bbq = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bbr = bbq + "/.tieba_video_cache";
    public static final String pC = bbr + "/v2";
    public static final String bbs = pC + "/";
    public static final String bbt = pC + "/files";
    public static final String bbu = bbt + "/";

    private static long hM(String str) {
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

    private static String hN(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long rq(String str) {
        try {
            String hN = hN(str);
            if (StringUtils.isNULL(hN)) {
                return 0L;
            }
            return hM(hN);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
