package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
/* loaded from: classes.dex */
public class au {
    public static final void a(Context context, y yVar, int i) {
        if (context != null && yVar != null) {
            if (!(!TextUtils.isEmpty(yVar.getPkgName()))) {
                com.baidu.adp.lib.util.n.showToast(context, com.baidu.tieba.t.pb_app_error);
            } else if (com.baidu.adp.lib.util.k.iX()) {
                yVar.iJ(1);
                TiebaStatic.eventStat(context, "pb_dl_app", null, 1, "app_name", yVar.getPkgName());
                com.baidu.tbadk.download.b.zf().a(yVar.getPkgName(), yVar.getDownloadUrl(), yVar.getAppName(), i, 0);
            } else {
                com.baidu.adp.lib.util.n.showToast(context, com.baidu.tieba.t.neterror);
            }
        }
    }

    public static final void a(Context context, y yVar) {
        if (context != null && yVar != null) {
            String pkgName = yVar.getPkgName();
            if (TextUtils.isEmpty(pkgName)) {
                com.baidu.adp.lib.util.n.showToast(context, com.baidu.tieba.t.pb_app_error);
                return;
            }
            File cB = com.baidu.tbadk.core.util.o.cB(String.valueOf(pkgName.replace(".", "_")) + ".apk");
            if (cB != null) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(cB), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }
}
