package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import java.io.File;
/* loaded from: classes.dex */
public class ag {
    public static final boolean a(Context context, q qVar, int i) {
        if (context == null || qVar == null) {
            return false;
        }
        if (!(!TextUtils.isEmpty(qVar.getPkgName()))) {
            com.baidu.adp.lib.util.k.showToast(context, i.h.pb_app_error);
            return false;
        } else if (com.baidu.adp.lib.util.i.iM()) {
            qVar.hS(1);
            TiebaStatic.eventStat(context, "pb_dl_app", null, 1, "app_name", qVar.getPkgName());
            com.baidu.tbadk.download.b.An().a(qVar.getPkgName(), qVar.getDownloadUrl(), qVar.getAppName(), i, 0);
            return true;
        } else {
            com.baidu.adp.lib.util.k.showToast(context, i.h.neterror);
            return false;
        }
    }

    public static final void a(Context context, q qVar) {
        if (context != null && qVar != null) {
            String pkgName = qVar.getPkgName();
            if (TextUtils.isEmpty(pkgName)) {
                com.baidu.adp.lib.util.k.showToast(context, i.h.pb_app_error);
                return;
            }
            File cI = com.baidu.tbadk.core.util.n.cI(String.valueOf(pkgName.replace(".", "_")) + ".apk");
            if (cI != null) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(cI), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }
}
