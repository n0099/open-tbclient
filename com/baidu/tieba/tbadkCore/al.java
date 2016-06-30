package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
import java.io.File;
/* loaded from: classes.dex */
public class al {
    public static final boolean a(Context context, com.baidu.tbadk.core.data.b bVar, int i) {
        if (context == null || bVar == null) {
            return false;
        }
        String str = bVar.MH;
        if (StringUtils.isNull(str) && bVar.MW != null) {
            str = bVar.MW.userName;
        }
        if (StringUtils.isNull(str)) {
            str = "";
        }
        return a(context, bVar, i, str);
    }

    public static final boolean a(Context context, com.baidu.tbadk.core.data.b bVar, int i, String str) {
        if (context == null || bVar == null) {
            return false;
        }
        if (!(!TextUtils.isEmpty(bVar.MN))) {
            com.baidu.adp.lib.util.k.showToast(context, u.j.pb_app_error);
            return false;
        } else if (!com.baidu.adp.lib.util.i.fr()) {
            com.baidu.adp.lib.util.k.showToast(context, u.j.neterror);
            return false;
        } else {
            com.baidu.tbadk.distribute.a.AU().a(bVar);
            String str2 = bVar.MH;
            if (StringUtils.isNull(str2)) {
                str2 = str;
            }
            com.baidu.tbadk.download.b.Ba().a(bVar.MN, bVar.MK, str2, i, com.baidu.adp.lib.h.b.g(bVar.MG, 0));
            return true;
        }
    }

    public static final void f(com.baidu.tbadk.core.data.b bVar) {
        com.baidu.tbadk.download.b.Ba().e(bVar.MK, bVar.MN, true);
    }

    public static final void a(Context context, r rVar) {
        if (context != null && rVar != null) {
            G(context, rVar.ip());
        }
    }

    public static final void G(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.k.showToast(context, u.j.pb_app_error);
            return;
        }
        File cR = com.baidu.tbadk.core.util.m.cR(String.valueOf(str.replace(".", "_")) + ".apk");
        if (cR != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(cR), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }

    public static boolean s(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean U = com.baidu.tbadk.core.util.ag.U(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return U;
    }
}
