package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import java.io.File;
/* loaded from: classes.dex */
public class ah {
    public static final boolean a(Context context, r rVar, int i) {
        if (context == null || rVar == null) {
            return false;
        }
        if (!(!TextUtils.isEmpty(rVar.getPkgName()))) {
            com.baidu.adp.lib.util.k.showToast(context, n.i.pb_app_error);
            return false;
        } else if (com.baidu.adp.lib.util.i.iP()) {
            rVar.ja(1);
            TiebaStatic.eventStat(context, "pb_dl_app", null, 1, "app_name", rVar.getPkgName());
            com.baidu.tbadk.download.b.Bm().a(rVar.getPkgName(), rVar.getDownloadUrl(), rVar.getAppName(), i, 0);
            return true;
        } else {
            com.baidu.adp.lib.util.k.showToast(context, n.i.neterror);
            return false;
        }
    }

    public static final void a(Context context, r rVar) {
        if (context != null && rVar != null) {
            String pkgName = rVar.getPkgName();
            if (TextUtils.isEmpty(pkgName)) {
                com.baidu.adp.lib.util.k.showToast(context, n.i.pb_app_error);
                return;
            }
            File cR = com.baidu.tbadk.core.util.n.cR(String.valueOf(pkgName.replace(".", "_")) + ".apk");
            if (cR != null) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(cR), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }
}
