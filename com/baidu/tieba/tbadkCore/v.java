package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.d;
import java.io.File;
/* loaded from: classes.dex */
public class v {
    public static final void ao(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.l.showToast(context, d.j.download_error);
            return;
        }
        File dC = com.baidu.tbadk.core.util.k.dC(str.replace(Constants.DOT, "_") + ".apk");
        if (dC != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(dC, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean C(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean aW = ab.aW(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return aW;
    }
}
