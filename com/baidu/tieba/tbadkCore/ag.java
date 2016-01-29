package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import java.io.File;
/* loaded from: classes.dex */
public class ag {
    public static final boolean a(Context context, com.baidu.tbadk.core.data.c cVar, int i) {
        if (context == null || cVar == null) {
            return false;
        }
        String str = cVar.Uu;
        if (StringUtils.isNull(str) && cVar.UI != null) {
            str = cVar.UI.userName;
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
        if (!(!TextUtils.isEmpty(cVar.Uy))) {
            com.baidu.adp.lib.util.k.showToast(context, t.j.pb_app_error);
            return false;
        } else if (!com.baidu.adp.lib.util.i.iZ()) {
            com.baidu.adp.lib.util.k.showToast(context, t.j.neterror);
            return false;
        } else {
            com.baidu.tbadk.distribute.a.Cl().a(cVar);
            String str2 = cVar.Uu;
            if (StringUtils.isNull(str2)) {
                str2 = str;
            }
            com.baidu.tbadk.download.b.Cr().a(cVar.Uy, cVar.Ux, str2, i, com.baidu.adp.lib.h.b.g(cVar.Ut, 0));
            return true;
        }
    }

    public static final void e(com.baidu.tbadk.core.data.c cVar) {
        com.baidu.tbadk.download.b.Cr().ai(cVar.Ux, cVar.Uy);
    }

    public static final void a(Context context, q qVar) {
        if (context != null && qVar != null) {
            N(context, qVar.getPkgName());
        }
    }

    public static final void N(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.k.showToast(context, t.j.pb_app_error);
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
}
