package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class u {
    public static final String cVD = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cVE = cVD + "/.tieba_video_cache";
    public static final String wy = cVE + "/v2";
    public static final String cVF = wy + "/";
    public static final String cVG = wy + "/files";
    public static final String cVH = cVG + "/";

    private static long rZ(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(cVH + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String sa(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long CZ(String str) {
        try {
            String sa = sa(str);
            if (StringUtils.isNULL(sa)) {
                return 0L;
            }
            return rZ(sa);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
