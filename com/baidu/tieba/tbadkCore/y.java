package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes2.dex */
public class y {
    public static boolean isInstalledPackage(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean as(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean checkWriteExternalStorage = ae.checkWriteExternalStorage(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return checkWriteExternalStorage;
    }
}
