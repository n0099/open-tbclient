package com.baidu.tieba.recapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.d.a;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.bFt;
        if (StringUtils.isNull(str) && advertAppInfo.bFC != null) {
            str = advertAppInfo.bFC.userName;
        }
        if (StringUtils.isNull(str)) {
            str = "";
        }
        return a(context, advertAppInfo, i, str, downloadStaticsData);
    }

    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, String str) {
        return a(context, advertAppInfo, i, str, null);
    }

    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, String str, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        com.baidu.tbadk.distribute.a.arZ().b(advertAppInfo);
        String str2 = advertAppInfo.bFt;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        com.baidu.tieba.recapp.download.e.ciQ().a(advertAppInfo.bFw, advertAppInfo.bFv, str2, i, com.baidu.tieba.recapp.download.e.Eg(advertAppInfo.bFw).intValue(), null, true, false, true, advertAppInfo.bFC.userPortrait, downloadStaticsData, advertAppInfo.bFC.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tieba.recapp.download.e.ciQ().z(advertAppInfo.bFv, advertAppInfo.bFw, true);
    }

    public static final void aN(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.l.showToast(context, (int) R.string.download_error);
            return;
        }
        File nm = com.baidu.tbadk.core.util.m.nm(str.replace(".", "_") + ".apk");
        if (nm != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(nm, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static boolean e(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(268435456);
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
        if (context.getPackageManager().getApplicationInfo(str, 8192) != null) {
            return true;
        }
        return false;
    }

    public static boolean at(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean cB = ab.cB(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return cB;
    }

    public static void a(String str, TbImageView tbImageView, float f, int i) {
        if (tbImageView != null) {
            if (TextUtils.isEmpty(str)) {
                tbImageView.setVisibility(8);
                return;
            }
            tbImageView.setDefaultErrorResource(R.drawable.icon_advert);
            tbImageView.setDefaultResource(0);
            tbImageView.setDefaultBgResource(0);
            tbImageView.startLoad(str, 10, false);
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                if (f <= 0.0f) {
                    f = 2.0f;
                }
                layoutParams.width = (int) (layoutParams.height * f);
                tbImageView.setLayoutParams(layoutParams);
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    tbImageView.setAlpha(0.8f);
                }
            }
            tbImageView.setVisibility(0);
        }
    }

    public static void b(String str, final TbImageView tbImageView, final float f, final int i) {
        if (tbImageView != null) {
            if (TextUtils.isEmpty(str)) {
                tbImageView.setVisibility(8);
                return;
            }
            tbImageView.setDefaultErrorResource(R.drawable.icon_advert);
            tbImageView.setDefaultResource(0);
            tbImageView.setDefaultBgResource(0);
            tbImageView.startLoad(str, 10, false);
            tbImageView.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.s.1
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str2, boolean z) {
                    ViewGroup.LayoutParams layoutParams = TbImageView.this.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = i;
                        layoutParams.width = (int) ((f > 0.0f ? f : 2.0f) * layoutParams.height);
                        TbImageView.this.setLayoutParams(layoutParams);
                        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            TbImageView.this.setAlpha(0.8f);
                        }
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
    }

    public static void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        r.ciJ().sendFRS(z, str, str2, str3, list, str4);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        r.ciJ().a(z, str, str2, str3, str4, list, str5);
    }

    public static int a(TbPageContext tbPageContext, String str, String str2) {
        if (com.baidu.tieba.a.aAF().aAG() != 1) {
            return e(tbPageContext, str);
        }
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("tieba://deeplink?")) {
            Uri parse = Uri.parse(str);
            if (e(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter("jump")))) {
                return 1;
            }
            return f(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (!TextUtils.isEmpty(str2)) {
            buildUpon.appendQueryParameter(LegoListActivityConfig.AD_ID, str2);
        }
        return f(tbPageContext, buildUpon.toString()) ? 3 : 0;
    }

    public static int e(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return f(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (e(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter("jump")))) {
            return 1;
        }
        return f(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean f(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        h ciG = r.ciJ().ciG();
        if (ciG == null) {
            return false;
        }
        if (ciG.sC(str)) {
            ciG.a(tbPageContext.getPageActivity(), strArr, true);
            return true;
        }
        return ciG.c(tbPageContext.getPageActivity(), strArr);
    }

    public static int aO(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return aP(context, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (e(context, Uri.parse(parse.getQueryParameter("jump")))) {
            return 1;
        }
        return aP(context, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean aP(Context context, String str) {
        String[] strArr = {str};
        h ciG = r.ciJ().ciG();
        if (ciG == null) {
            return false;
        }
        if (ciG.sC(str)) {
            ciG.a(context, strArr, true);
            return true;
        }
        return ciG.c(context, strArr);
    }
}
