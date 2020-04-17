package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class t {
    public static final String exz = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String exA = exz + "/.tieba_video_cache";
    public static final String HG = exA + "/v2";
    public static final String exB = HG + "/";
    public static final String exC = HG + "/files";
    public static final String exD = exC + "/";

    private static long xP(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(exD + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String xQ(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long IK(String str) {
        try {
            String xQ = xQ(str);
            if (StringUtils.isNULL(xQ)) {
                return 0L;
            }
            return xP(xQ);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
