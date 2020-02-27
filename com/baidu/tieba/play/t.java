package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class t {
    public static final String dXa = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String dXb = dXa + "/.tieba_video_cache";
    public static final String oC = dXb + "/v2";
    public static final String dXc = oC + "/";
    public static final String dXd = oC + "/files";
    public static final String dXe = dXd + "/";

    private static long wB(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(dXe + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String wC(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long Hc(String str) {
        try {
            String wC = wC(str);
            if (StringUtils.isNULL(wC)) {
                return 0L;
            }
            return wB(wC);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
