package com.baidu.tieba.recapp;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private static String mTn = TbadkCoreApplication.getInst().getApp().getExternalCacheDir() + "/nadDir";

    public static File Rq(@NonNull String str) {
        return !com.baidu.tieba.a.bJk().bJs() ? com.baidu.tbadk.core.util.o.GetFile(str) : Ru(getFilePath(str));
    }

    public static String Rr(String str) {
        return getFilePath(Rs(str));
    }

    private static String getFilePath(@NonNull String str) {
        if (!com.baidu.tieba.a.bJk().bJs()) {
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.tbadk.core.util.o.getCacheDir());
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mTn);
        File file2 = new File(sb2.toString());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        sb2.append("/");
        sb2.append(str);
        return sb2.toString();
    }

    public static String Rs(@NonNull String str) {
        return str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk";
    }

    public static String gh(@NonNull String str, @NonNull String str2) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + ".tmp";
    }

    public static boolean Rt(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return af(Rq(Rs(str)));
    }

    public static boolean gi(@NonNull String str, @NonNull String str2) {
        if (TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L) == 0) {
            return false;
        }
        return af(Rq(gh(str, str2)));
    }

    public static File createFileIfNotFound(@NonNull String str) {
        return com.baidu.tbadk.core.util.o.CreateFileIfNotFoundAbsolutePath(getFilePath(str));
    }

    public static File Ru(@NonNull String str) {
        return com.baidu.tbadk.core.util.o.GetFileByAbsolutePath(str);
    }

    public static void Rv(String str) {
        deleteFileOrDir(Rq(Rs(str)));
    }

    public static void deleteFileOrDir(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            if (listFiles[i].isFile()) {
                                listFiles[i].delete();
                            } else {
                                deleteFileOrDir(listFiles[i]);
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.deleteFileOrDir");
            }
        }
    }

    public static boolean af(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
