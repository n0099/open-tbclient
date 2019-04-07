package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class u {
    public static final String cLM = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cLN = cLM + "/.tieba_video_cache";
    public static final String yL = cLN + "/v2";
    public static final String cLO = yL + "/";
    public static final String cLP = yL + "/files";
    public static final String cLQ = cLP + "/";

    private static long qz(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(cLQ + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String qA(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long AR(String str) {
        try {
            String qA = qA(str);
            if (StringUtils.isNULL(qA)) {
                return 0L;
            }
            return qz(qA);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
