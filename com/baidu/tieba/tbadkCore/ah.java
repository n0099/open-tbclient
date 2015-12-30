package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import java.io.File;
/* loaded from: classes.dex */
public class ah {
    public static final boolean a(Context context, com.baidu.tbadk.core.data.b bVar, int i) {
        if (context == null || bVar == null) {
            return false;
        }
        String str = bVar.UN;
        if (StringUtils.isNull(str) && bVar.Vb != null) {
            str = bVar.Vb.userName;
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
        if (!(!TextUtils.isEmpty(bVar.US))) {
            com.baidu.adp.lib.util.k.showToast(context, n.j.pb_app_error);
            return false;
        } else if (!com.baidu.adp.lib.util.i.iQ()) {
            com.baidu.adp.lib.util.k.showToast(context, n.j.neterror);
            return false;
        } else {
            com.baidu.tbadk.distribute.a.AV().a(bVar);
            String str2 = bVar.UN;
            if (StringUtils.isNull(str2)) {
                str2 = str;
            }
            com.baidu.tbadk.download.b.Bb().a(bVar.US, bVar.UR, str2, i, com.baidu.adp.lib.h.b.g(bVar.UM, 0));
            return true;
        }
    }

    public static final void a(Context context, r rVar) {
        if (context != null && rVar != null) {
            String pkgName = rVar.getPkgName();
            if (TextUtils.isEmpty(pkgName)) {
                com.baidu.adp.lib.util.k.showToast(context, n.j.pb_app_error);
                return;
            }
            File cU = com.baidu.tbadk.core.util.n.cU(String.valueOf(pkgName.replace(".", "_")) + ".apk");
            if (cU != null) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(cU), "application/vnd.android.package-archive");
                context.startActivity(intent);
            }
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }
}
