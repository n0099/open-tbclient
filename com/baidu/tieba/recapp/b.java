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
    private static String mRi = TbadkCoreApplication.getInst().getApp().getExternalCacheDir() + "/nadDir";

    public static File Rk(@NonNull String str) {
        return !com.baidu.tieba.a.bJg().bJo() ? com.baidu.tbadk.core.util.o.GetFile(str) : Ro(getFilePath(str));
    }

    public static String Rl(String str) {
        return getFilePath(Rm(str));
    }

    private static String getFilePath(@NonNull String str) {
        if (!com.baidu.tieba.a.bJg().bJo()) {
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
        sb2.append(mRi);
        File file2 = new File(sb2.toString());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        sb2.append("/");
        sb2.append(str);
        return sb2.toString();
    }

    public static String Rm(@NonNull String str) {
        return str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk";
    }

    public static String gh(@NonNull String str, @NonNull String str2) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + ".tmp";
    }

    public static boolean Rn(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return af(Rk(Rm(str)));
    }

    public static boolean gi(@NonNull String str, @NonNull String str2) {
        if (TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L) == 0) {
            return false;
        }
        return af(Rk(gh(str, str2)));
    }

    public static File createFileIfNotFound(@NonNull String str) {
        return com.baidu.tbadk.core.util.o.CreateFileIfNotFoundAbsolutePath(getFilePath(str));
    }

    public static File Ro(@NonNull String str) {
        return com.baidu.tbadk.core.util.o.GetFileByAbsolutePath(str);
    }

    public static void Rp(String str) {
        deleteFileOrDir(Rk(Rm(str)));
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
