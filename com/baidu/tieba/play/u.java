package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class u {
    public static final String cLK = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cLL = cLK + "/.tieba_video_cache";
    public static final String yM = cLL + "/v2";
    public static final String cLM = yM + "/";
    public static final String cLN = yM + "/files";
    public static final String cLO = cLN + "/";

    private static long qy(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(cLO + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String qz(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long AS(String str) {
        try {
            String qz = qz(str);
            if (StringUtils.isNULL(qz)) {
                return 0L;
            }
            return qy(qz);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
