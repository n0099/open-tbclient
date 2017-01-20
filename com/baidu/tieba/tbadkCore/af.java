package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
import java.io.File;
/* loaded from: classes.dex */
public class af {
    public static final void S(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.k.showToast(context, r.l.download_error);
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
        boolean ae = com.baidu.tbadk.core.util.ad.ae(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return ae;
    }
}
