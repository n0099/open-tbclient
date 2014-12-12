package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
/* loaded from: classes.dex */
public class ar {
    public static final void a(Context context, v vVar, int i) {
        if (context != null && vVar != null) {
            if (!(!TextUtils.isEmpty(vVar.getPkgName()))) {
                com.baidu.adp.lib.util.l.showToast(context, com.baidu.tieba.z.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.fg()) {
                vVar.hA(1);
                TiebaStatic.eventStat(context, "pb_dl_app", null, 1, "app_name", vVar.getPkgName());
                com.baidu.tbadk.download.b.uK().a(vVar.getPkgName(), vVar.getDownloadUrl(), vVar.getAppName(), i, 0);
            } else {
                com.baidu.adp.lib.util.l.showToast(context, com.baidu.tieba.z.neterror);
            }
        }
    }

    public static final void a(Context context, v vVar) {
        if (context != null && vVar != null) {
            String pkgName = vVar.getPkgName();
            if (TextUtils.isEmpty(pkgName)) {
                com.baidu.adp.lib.util.l.showToast(context, com.baidu.tieba.z.pb_app_error);
                return;
            }
            File cj = com.baidu.tbadk.core.util.s.cj(String.valueOf(pkgName.replace(".", "_")) + ".apk");
            if (cj != null) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(cj), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }
}
