package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.tieba.r;
import java.io.File;
/* loaded from: classes.dex */
public class ak {
    public static final void Q(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.k.showToast(context, r.j.pb_app_error);
            return;
        }
        File cW = com.baidu.tbadk.core.util.m.cW(String.valueOf(str.replace(".", "_")) + ".apk");
        if (cW != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(cW), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }

    public static boolean w(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean ae = com.baidu.tbadk.core.util.ag.ae(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return ae;
    }
}
