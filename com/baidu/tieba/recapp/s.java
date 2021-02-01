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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.d.a;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static volatile boolean mRu = false;

    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.eLv;
        if (StringUtils.isNull(str) && advertAppInfo.eLD != null) {
            str = advertAppInfo.eLD.userName;
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
        com.baidu.tbadk.distribute.a.bAU().b(advertAppInfo);
        String str2 = advertAppInfo.eLv;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        com.baidu.tieba.recapp.download.e.dDt().a(advertAppInfo.eLx, advertAppInfo.apkUrl, str2, i, com.baidu.tieba.recapp.download.e.Rr(advertAppInfo.eLx).intValue(), null, true, false, true, advertAppInfo.eLD.userPortrait, downloadStaticsData, advertAppInfo.eLD.userName);
        return true;
    }

    public static final void i(AdvertAppInfo advertAppInfo) {
        com.baidu.tieba.recapp.download.e.dDt().F(advertAppInfo.apkUrl, advertAppInfo.eLx, true);
    }

    public static final void installApp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.l.showToast(context, R.string.download_error);
            return;
        }
        File GetFile = com.baidu.tbadk.core.util.o.GetFile(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
        if (GetFile != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static Intent bd(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static int f(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(268435456);
        try {
            if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                return 1004;
            }
            try {
                context.startActivity(intent);
                return 1000;
            } catch (Exception e) {
                return 1006;
            }
        } catch (Exception e2) {
            return 1006;
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

    public static boolean at(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean checkWriteExternalStorage = ae.checkWriteExternalStorage(activity);
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
        r.dDm().sendFRS(z, str, str2, str3, list, str4);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        r.dDm().a(z, str, str2, str3, str4, list, str5);
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
            return c(context, str, bundle) ? 1 : 0;
        }
        Uri parse = Uri.parse(str);
        int c = c(parse, context);
        if (c != 1000) {
            if (!c(context, parse.getQueryParameter("wap"), bundle)) {
                c = 0;
            }
            return c;
        }
        return 1000;
    }

    private static int c(Uri uri, Context context) {
        try {
            String queryParameter = uri.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            if (TextUtils.isEmpty(queryParameter)) {
                return 1003;
            }
            return f(context, Uri.parse(queryParameter));
        } catch (Exception e) {
            return 1003;
        }
    }

    private static boolean c(@NonNull Context context, String str, Bundle bundle) {
        String[] strArr = {str};
        i dDj = r.dDm().dDj();
        if (dDj == null) {
            return false;
        }
        if (dDj.EC(str)) {
            dDj.a(context, strArr, true, bundle);
            return true;
        }
        return dDj.a(context, strArr, bundle);
    }

    public static int a(Context context, String str, AdvertAppInfo advertAppInfo) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("tieba://deeplink?")) {
            int c = c(Uri.parse(str), context);
            if (c != 1000) {
                r.dDm().a(advertAppInfo, context);
                return c;
            }
            return 1000;
        }
        r.dDm().a(advertAppInfo, context);
        return 1;
    }

    public static int be(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || !str.startsWith("tieba://deeplink?")) {
            return 0;
        }
        return c(Uri.parse(str), context);
    }

    public static boolean Rm(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?");
    }

    public static String Rn(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?")) {
            return Uri.parse(str).getQueryParameter("wap");
        }
        return str;
    }

    public static boolean b(AdvertAppInfo advertAppInfo, String str) {
        if (advertAppInfo == null || !advertAppInfo.blE() || TextUtils.isEmpty(str) || !isInstalledPackage(TbadkCoreApplication.getInst(), advertAppInfo.eLx) || str.startsWith("tieba://deeplink?")) {
            return false;
        }
        return j(advertAppInfo);
    }

    public static boolean j(AdvertAppInfo advertAppInfo) {
        Context context;
        Intent bd;
        if (advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.eLx;
        if (TextUtils.isEmpty(str) || (bd = bd((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
            return false;
        }
        try {
            context.startActivity(bd);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean HL(int i) {
        switch (i) {
            case 1000:
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
                return true;
            default:
                return false;
        }
    }

    public static void dDn() {
        if (!com.baidu.tieba.a.bJg().bJj() && !mRu) {
            mRu = true;
            for (String str : new String[]{"com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic"}) {
                try {
                    Class.forName(str);
                } catch (Throwable th) {
                }
            }
        }
    }
}
