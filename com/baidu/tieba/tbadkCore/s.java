package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.d;
import java.io.File;
/* loaded from: classes.dex */
public class s {
    public static final void aq(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.k.showToast(context, d.l.download_error);
            return;
        }
        File m9do = com.baidu.tbadk.core.util.k.m9do(str.replace(".", "_") + ".apk");
        if (m9do != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(m9do, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        if (context.getPackageManager().getApplicationInfo(str, 8192) != null) {
            return true;
        }
        return false;
    }

    public static boolean A(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean aN = ab.aN(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return aN;
    }
}
