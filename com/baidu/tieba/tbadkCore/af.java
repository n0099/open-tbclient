package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import java.io.File;
/* loaded from: classes.dex */
public class af {
    public static final void a(Context context, p pVar, int i) {
        if (context != null && pVar != null) {
            if (!(!TextUtils.isEmpty(pVar.getPkgName()))) {
                com.baidu.adp.lib.util.k.showToast(context, i.C0057i.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iO()) {
                pVar.jE(1);
                TiebaStatic.eventStat(context, "pb_dl_app", null, 1, "app_name", pVar.getPkgName());
                com.baidu.tbadk.download.b.Ap().a(pVar.getPkgName(), pVar.getDownloadUrl(), pVar.getAppName(), i, 0);
            } else {
                com.baidu.adp.lib.util.k.showToast(context, i.C0057i.neterror);
            }
        }
    }

    public static final void a(Context context, p pVar) {
        if (context != null && pVar != null) {
            String pkgName = pVar.getPkgName();
            if (TextUtils.isEmpty(pkgName)) {
                com.baidu.adp.lib.util.k.showToast(context, i.C0057i.pb_app_error);
                return;
            }
            File cC = com.baidu.tbadk.core.util.n.cC(String.valueOf(pkgName.replace(".", "_")) + ".apk");
            if (cC != null) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(cC), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }
}
