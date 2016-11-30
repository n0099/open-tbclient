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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.d.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    public static final boolean a(Context context, com.baidu.tbadk.core.data.c cVar, int i, DownloadStaticsData downloadStaticsData) {
        if (context == null || cVar == null) {
            return false;
        }
        String str = cVar.Pn;
        if (StringUtils.isNull(str) && cVar.Pz != null) {
            str = cVar.Pz.userName;
        }
        if (StringUtils.isNull(str)) {
            str = "";
        }
        return a(context, cVar, i, str, downloadStaticsData);
    }

    public static final boolean a(Context context, com.baidu.tbadk.core.data.c cVar, int i, String str) {
        return a(context, cVar, i, str, null);
    }

    public static final boolean a(Context context, com.baidu.tbadk.core.data.c cVar, int i, String str, DownloadStaticsData downloadStaticsData) {
        if (context == null || cVar == null) {
            return false;
        }
        com.baidu.tbadk.distribute.a.Cx().b(cVar);
        String str2 = cVar.Pn;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        com.baidu.tieba.recapp.b.a.beu().a(cVar.Ps, cVar.Pq, str2, i, com.baidu.tieba.recapp.b.a.qU(cVar.Ps).intValue(), null, true, false, true, cVar.Pz.userPortrait, downloadStaticsData, cVar.Pz.userName);
        return true;
    }

    public static final void e(com.baidu.tbadk.core.data.c cVar) {
        com.baidu.tieba.recapp.b.a.beu().h(cVar.Pq, cVar.Ps, true);
    }

    public static final void R(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(context, r.j.pb_app_error);
            return;
        }
        File cY = m.cY(String.valueOf(str.replace(".", "_")) + ".apk");
        if (cY != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(cY), "application/vnd.android.package-archive");
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
        boolean ae = ae.ae(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return ae;
    }

    public static List<String> bp(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(8192);
        if (installedApplications != null && !installedApplications.isEmpty()) {
            for (ApplicationInfo applicationInfo : installedApplications) {
                if (!StringUtils.isNull(applicationInfo.packageName)) {
                    arrayList.add(applicationInfo.packageName);
                }
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
            tbImageView.setDefaultErrorResource(r.f.icon_advert);
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
            tbImageView.setVisibility(0);
        }
    }

    public static void b(String str, TbImageView tbImageView, float f, int i) {
        if (tbImageView != null) {
            if (TextUtils.isEmpty(str)) {
                tbImageView.setVisibility(8);
                return;
            }
            tbImageView.setDefaultErrorResource(r.f.icon_advert);
            tbImageView.setDefaultResource(0);
            tbImageView.setDefaultBgResource(0);
            tbImageView.c(str, 10, false);
            tbImageView.setEvent(new h(tbImageView, i, f));
        }
    }

    public static void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        e.bes().sendFRS(z, str, str2, str3, list, str4);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        e.bes().a(z, str, str2, str3, str4, list, str5);
    }
}
