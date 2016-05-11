package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import java.io.File;
/* loaded from: classes.dex */
public class ah {
    public static final boolean a(Context context, com.baidu.tbadk.core.data.c cVar, int i) {
        if (context == null || cVar == null) {
            return false;
        }
        String str = cVar.MO;
        if (StringUtils.isNull(str) && cVar.Nb != null) {
            str = cVar.Nb.userName;
        }
        if (StringUtils.isNull(str)) {
            str = "";
        }
        return a(context, cVar, i, str);
    }

    public static final boolean a(Context context, com.baidu.tbadk.core.data.c cVar, int i, String str) {
        if (context == null || cVar == null) {
            return false;
        }
        if (!(!TextUtils.isEmpty(cVar.MS))) {
            com.baidu.adp.lib.util.k.showToast(context, t.j.pb_app_error);
            return false;
        } else if (!com.baidu.adp.lib.util.i.fq()) {
            com.baidu.adp.lib.util.k.showToast(context, t.j.neterror);
            return false;
        } else {
            com.baidu.tbadk.distribute.a.AK().a(cVar);
            String str2 = cVar.MO;
            if (StringUtils.isNull(str2)) {
                str2 = str;
            }
            com.baidu.tbadk.download.b.AQ().a(cVar.MS, cVar.MR, str2, i, com.baidu.adp.lib.h.b.g(cVar.MN, 0));
            return true;
        }
    }

    public static final void e(com.baidu.tbadk.core.data.c cVar) {
        com.baidu.tbadk.download.b.AQ().e(cVar.MR, cVar.MS, true);
    }

    public static final void a(Context context, q qVar) {
        if (context != null && qVar != null) {
            F(context, qVar.getPkgName());
        }
    }

    public static final void F(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.k.showToast(context, t.j.pb_app_error);
            return;
        }
        File cS = com.baidu.tbadk.core.util.m.cS(String.valueOf(str.replace(".", "_")) + ".apk");
        if (cS != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(cS), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }

    public static boolean q(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean V = com.baidu.tbadk.core.util.ag.V(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return V;
    }
}
