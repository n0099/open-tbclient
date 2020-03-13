package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class t {
    public static final String dXo = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String dXp = dXo + "/.tieba_video_cache";
    public static final String oC = dXp + "/v2";
    public static final String dXq = oC + "/";
    public static final String dXr = oC + "/files";
    public static final String dXs = dXr + "/";

    private static long wC(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(dXs + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String wD(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long Hd(String str) {
        try {
            String wD = wD(str);
            if (StringUtils.isNULL(wD)) {
                return 0L;
            }
            return wC(wD);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
