package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class t {
    public static final String blb = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String blc = blb + "/.tieba_video_cache";
    public static final String vO = blc + "/v2";
    public static final String bld = vO + "/";
    public static final String ble = vO + "/files";
    public static final String blf = ble + "/";

    private static long ir(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(blf + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    private static String is(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }

    public static long sj(String str) {
        try {
            String is = is(str);
            if (StringUtils.isNULL(is)) {
                return 0L;
            }
            return ir(is);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
