package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class u {
    public static final String cLN = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cLO = cLN + "/.tieba_video_cache";
    public static final String yM = cLO + "/v2";
    public static final String cLP = yM + "/";
    public static final String cLQ = yM + "/files";
    public static final String cLR = cLQ + "/";

    private static long qA(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(cLR + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String qB(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long AU(String str) {
        try {
            String qB = qB(str);
            if (StringUtils.isNULL(qB)) {
                return 0L;
            }
            return qA(qB);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
