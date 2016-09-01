package com.baidu.tieba.recapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    public static final boolean a(Context context, com.baidu.tbadk.core.data.b bVar, int i) {
        if (context == null || bVar == null) {
            return false;
        }
        String str = bVar.OZ;
        if (StringUtils.isNull(str) && bVar.Pn != null) {
            str = bVar.Pn.userName;
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
        if (!(!TextUtils.isEmpty(bVar.Pe))) {
            k.showToast(context, t.j.pb_app_error);
            return false;
        } else if (!i.gm()) {
            k.showToast(context, t.j.neterror);
            return false;
        } else {
            com.baidu.tbadk.distribute.a.Cp().a(bVar);
            String str2 = bVar.OZ;
            if (StringUtils.isNull(str2)) {
                str2 = str;
            }
            com.baidu.tieba.recapp.b.a.bbr().a(bVar.Pe, bVar.Pc, str2, i, com.baidu.adp.lib.h.b.g(bVar.OY, 0));
            return true;
        }
    }

    public static final void d(com.baidu.tbadk.core.data.b bVar) {
        com.baidu.tieba.recapp.b.a.bbr().h(bVar.Pc, bVar.Pe, true);
    }

    public static final void Q(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(context, t.j.pb_app_error);
            return;
        }
        File cU = m.cU(String.valueOf(str.replace(".", "_")) + ".apk");
        if (cU != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(cU), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static boolean c(Context context, Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        try {
            if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                return false;
            }
        } catch (Exception e) {
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean isInstalledPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 8192) != null;
    }

    public static boolean w(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean ae = ag.ae(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return ae;
    }

    public static List<String> bd(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(8192);
        if (installedApplications != null && !installedApplications.isEmpty()) {
            for (ApplicationInfo applicationInfo : installedApplications) {
                arrayList.add(applicationInfo.packageName);
            }
        }
        return arrayList;
    }

    public static void a(String str, TbImageView tbImageView, float f, int i) {
        if (tbImageView != null) {
            if (TextUtils.isEmpty(str)) {
                tbImageView.setVisibility(8);
                return;
            }
            tbImageView.setDefaultErrorResource(t.f.icon_advert);
            tbImageView.setDefaultResource(0);
            tbImageView.setDefaultBgResource(0);
            tbImageView.c(str, 10, false);
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                if (f <= 0.0f) {
                    f = 2.0f;
                }
                layoutParams.width = (int) (layoutParams.height * f);
                tbImageView.setLayoutParams(layoutParams);
                if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                    tbImageView.setAlpha(0.8f);
                }
            }
        }
    }
}
