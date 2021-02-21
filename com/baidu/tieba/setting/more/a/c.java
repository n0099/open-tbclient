package com.baidu.tieba.setting.more.a;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes8.dex */
public class c {
    public static String dIT() {
        try {
            return Environment.getExternalStorageDirectory() + File.separator + "tieba/Logs/";
        } catch (Exception e) {
            BdLog.e(Log.getStackTraceString(e));
            return null;
        }
    }

    public static String dIU() {
        return dIV() + "tieba/Logs/";
    }

    private static String dIV() {
        String path = Environment.getExternalStorageDirectory().getPath();
        int length = path.length() - 1;
        if (length > 0 && !path.substring(length).equals(File.separator)) {
            return path + File.separator;
        }
        return path;
    }

    public static boolean Sx(String str) {
        String Sy = Sy(str);
        if (TextUtils.isEmpty(Sy)) {
            return false;
        }
        File file = new File(Sy);
        return (file.exists() && file.isDirectory()) || file.mkdirs();
    }

    private static String Sy(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(File.separator);
            return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
        }
        return str;
    }
}
