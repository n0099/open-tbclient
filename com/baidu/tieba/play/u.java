package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class u {
    public static final String bvI = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bvJ = bvI + "/.tieba_video_cache";
    public static final String yM = bvJ + "/v2";
    public static final String bvK = yM + "/";
    public static final String bvL = yM + "/files";
    public static final String bvM = bvL + "/";

    private static long jd(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(bvM + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String je(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long to(String str) {
        try {
            String je = je(str);
            if (StringUtils.isNULL(je)) {
                return 0L;
            }
            return jd(je);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
