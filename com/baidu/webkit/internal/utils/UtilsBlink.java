package com.baidu.webkit.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import java.io.File;
/* loaded from: classes5.dex */
public class UtilsBlink implements INoProGuard {
    public static final String DEX_FILE_SUBFIX = ".dex";
    public static final String TAG = "UtilsBlink";
    public static final byte VER_TYPE_SEPARATOR = 45;

    public static boolean createDownloadLibPath(Context context) {
        getDataPath(context).length();
        File file = new File(getDownloadLibPath(context));
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    @SuppressLint({"SdCardPath"})
    public static String getDataPath(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getParent();
        }
        return "/data/data/" + context.getPackageName() + "/";
    }

    public static String getDownloadLibPath(Context context) {
        String filesPath = getFilesPath(context);
        if (filesPath != null) {
            return filesPath + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
        }
        return null;
    }

    @SuppressLint({"SdCardPath"})
    public static String getFilesPath(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath();
        }
        return "/data/data/" + context.getPackageName() + "/files/";
    }
}
