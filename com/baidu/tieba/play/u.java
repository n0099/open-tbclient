package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class u {
    public static final String cWw = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cWx = cWw + "/.tieba_video_cache";
    public static final String wy = cWx + "/v2";
    public static final String cWy = wy + "/";
    public static final String cWz = wy + "/files";
    public static final String cWA = cWz + "/";

    private static long sk(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(cWA + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String sl(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long Dy(String str) {
        try {
            String sl = sl(str);
            if (StringUtils.isNULL(sl)) {
                return 0L;
            }
            return sk(sl);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
