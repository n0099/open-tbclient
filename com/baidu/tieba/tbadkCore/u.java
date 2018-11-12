package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppFileClassifyHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.e;
import java.io.File;
/* loaded from: classes.dex */
public class u {
    public static final void aD(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.l.showToast(context, e.j.download_error);
            return;
        }
        File eC = com.baidu.tbadk.core.util.l.eC(str.replace(".", BaseRequestAction.SPLITE) + ".apk");
        if (eC != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(eC, intent, context), AiAppFileClassifyHelper.MIME_TYPE_APK);
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

    public static boolean O(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean bC = ab.bC(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return bC;
    }
}
