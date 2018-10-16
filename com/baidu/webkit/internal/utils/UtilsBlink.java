package com.baidu.webkit.internal.utils;

import android.content.Context;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import java.io.File;
/* loaded from: classes2.dex */
public class UtilsBlink implements INoProGuard {
    private static final String DEX_FILE_SUBFIX = ".dex";
    private static final String TAG = "UtilsBlink";
    private static final byte VER_TYPE_SEPARATOR = 45;

    public static boolean createDownloadLibPath(Context context) {
        getDataPath(context).length();
        File file = new File(getDownloadLibPath(context));
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    private static String getDataPath(Context context) {
        File filesDir = context.getFilesDir();
        return filesDir != null ? filesDir.getParent() : "/data/data/" + context.getPackageName() + "/";
    }

    public static String getDownloadLibPath(Context context) {
        String filesPath = getFilesPath(context);
        if (filesPath != null) {
            return filesPath + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
        }
        return null;
    }

    private static String getFilesPath(Context context) {
        File filesDir = context.getFilesDir();
        return filesDir != null ? filesDir.getAbsolutePath() : "/data/data/" + context.getPackageName() + "/files/";
    }
}
