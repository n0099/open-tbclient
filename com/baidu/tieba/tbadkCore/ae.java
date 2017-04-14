package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
import java.io.File;
/* loaded from: classes.dex */
public class ae {
    public static final void ap(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.k.showToast(context, w.l.download_error);
            return;
        }
        File cX = com.baidu.tbadk.core.util.l.cX(String.valueOf(str.replace(".", "_")) + ".apk");
        if (cX != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(cX, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }

    public static boolean x(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean aE = com.baidu.tbadk.core.util.ae.aE(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return aE;
    }
}
