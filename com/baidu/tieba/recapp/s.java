package com.baidu.tieba.recapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
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
        String str = advertAppInfo.eJj;
        if (StringUtils.isNull(str) && advertAppInfo.eJr != null) {
            str = advertAppInfo.eJr.userName;
        }
        if (StringUtils.isNull(str)) {
            str = "";
        }
        return a(context, advertAppInfo, i, str, downloadStaticsData);
    }

    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, String str, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        com.baidu.tbadk.distribute.a.bAC().b(advertAppInfo);
        String str2 = advertAppInfo.eJj;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        com.baidu.tieba.recapp.download.e.dBk().a(advertAppInfo.eJl, advertAppInfo.apkUrl, str2, i, com.baidu.tieba.recapp.download.e.Qw(advertAppInfo.eJl).intValue(), null, true, false, true, advertAppInfo.eJr.userPortrait, downloadStaticsData, advertAppInfo.eJr.userName);
        return true;
    }

    public static final void h(AdvertAppInfo advertAppInfo) {
        com.baidu.tieba.recapp.download.e.dBk().F(advertAppInfo.apkUrl, advertAppInfo.eJl, true);
    }

    public static final void installApp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.l.showToast(context, R.string.download_error);
            return;
        }
        File GetFile = com.baidu.tbadk.core.util.n.GetFile(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
        if (GetFile != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static Intent be(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean f(Context context, Uri uri) {
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
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean aA(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean checkWriteExternalStorage = ad.checkWriteExternalStorage(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return checkWriteExternalStorage;
    }

    public static void a(String str, TbImageView tbImageView, float f, int i) {
        if (tbImageView != null) {
            if (TextUtils.isEmpty(str)) {
                tbImageView.setVisibility(8);
                return;
            }
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
            tbImageView.setDefaultResource(0);
            tbImageView.setDefaultBgResource(0);
            tbImageView.startLoad(str, 10, false);
            tbImageView.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.s.1
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str2, boolean z) {
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

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        }
    }

    public static void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        r.dBe().sendFRS(z, str, str2, str3, list, str4);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        r.dBe().a(z, str, str2, str3, str4, list, str5);
    }

    public static int c(TbPageContext tbPageContext, String str, String str2) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return x(tbPageContext.getPageActivity(), str, str2);
    }

    public static int x(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str2);
        if (!str.startsWith("tieba://deeplink?")) {
            return c(context, str, bundle) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (f(context, Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
            return 1;
        }
        return c(context, parse.getQueryParameter("wap"), bundle) ? 2 : 0;
    }

    private static boolean c(@NonNull Context context, String str, Bundle bundle) {
        String[] strArr = {str};
        i dBb = r.dBe().dBb();
        if (dBb == null) {
            return false;
        }
        if (dBb.Ee(str)) {
            dBb.a(context, strArr, true, bundle);
            return true;
        }
        return dBb.a(context, strArr, bundle);
    }

    public static int a(Context context, String str, AdvertAppInfo advertAppInfo) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 2;
        }
        if (str.startsWith("tieba://deeplink?") && f(context, Uri.parse(Uri.parse(str).getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
            return 1;
        }
        r.dBe().a(advertAppInfo, context);
        return 2;
    }

    public static boolean bf(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || !str.startsWith("tieba://deeplink?")) {
            return false;
        }
        return f(context, Uri.parse(Uri.parse(str).getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)));
    }

    public static boolean Qr(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?");
    }

    public static String Qs(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?")) {
            return Uri.parse(str).getQueryParameter("wap");
        }
        return str;
    }

    public static boolean b(AdvertAppInfo advertAppInfo, String str) {
        if (advertAppInfo == null || !advertAppInfo.blm() || TextUtils.isEmpty(str) || !isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eJl) || str.startsWith("tieba://deeplink?")) {
            return false;
        }
        return i(advertAppInfo);
    }

    public static boolean i(AdvertAppInfo advertAppInfo) {
        Context context;
        Intent be;
        if (advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.eJl;
        if (TextUtils.isEmpty(str) || (be = be((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
            return false;
        }
        try {
            context.startActivity(be);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
