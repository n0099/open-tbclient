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
import com.baidu.live.tbadk.log.LogConfig;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    public static List<String> mRK;
    private static final String[] mRL = {"baiduboxapp", "taobao", LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND, "alipays"};
    private static volatile boolean mRM = false;

    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.eLu;
        if (StringUtils.isNull(str) && advertAppInfo.eLC != null) {
            str = advertAppInfo.eLC.userName;
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
        String str2 = advertAppInfo.eLu;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        com.baidu.tieba.recapp.download.e.dDA().a(advertAppInfo.eLw, advertAppInfo.apkUrl, str2, i, com.baidu.tieba.recapp.download.e.RD(advertAppInfo.eLw).intValue(), null, true, false, true, advertAppInfo.eLC.userPortrait, downloadStaticsData, advertAppInfo.eLC.userName);
        return true;
    }

    public static final void i(AdvertAppInfo advertAppInfo) {
        com.baidu.tieba.recapp.download.e.dDA().F(advertAppInfo.apkUrl, advertAppInfo.eLw, true);
    }

    @Deprecated
    public static final void installApp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.l.showToast(context, R.string.download_error);
            return;
        }
        File GetFile = com.baidu.tbadk.core.util.o.GetFile(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static boolean Rt(@NonNull String str) {
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.l.showToast(inst, R.string.download_error);
            return false;
        }
        File Ro = b.Ro(str);
        if (b.af(Ro)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(Ro, intent, inst), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            inst.startActivity(intent);
            return true;
        }
        return false;
    }

    public static Intent bb(Context context, String str) {
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

    public static boolean Ru(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return TbadkCoreApplication.getInst().getPackageManager().getApplicationInfo(str, 8192) != null;
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
            tbImageView.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.t.1
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
        s.dDt().sendFRS(z, str, str2, str3, list, str4);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        s.dDt().a(z, str, str2, str3, str4, list, str5);
    }

    public static int a(TbPageContext tbPageContext, String str, String str2, String str3) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return i(tbPageContext.getPageActivity(), str, str2, str3);
    }

    public static int i(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str2);
        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, str3);
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

    public static boolean r(String str, @NonNull Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.tieba.lego.card.c.a.isEmpty(mRK)) {
            mRK = com.baidu.tbadk.coreExtra.data.g.bwh();
            if (mRK == null) {
                mRK = new ArrayList();
            }
            mRK.addAll(Arrays.asList(mRL));
        }
        for (String str2 : mRK) {
            if (str.startsWith(str2)) {
                return f(context, Uri.parse(str)) == 1000;
            }
        }
        return false;
    }

    private static boolean c(@NonNull Context context, String str, Bundle bundle) {
        String[] strArr = {str};
        j dDq = s.dDt().dDq();
        if (dDq == null) {
            return false;
        }
        if (dDq.EA(str)) {
            dDq.a(context, strArr, true, bundle);
            return true;
        }
        return dDq.a(context, strArr, bundle);
    }

    public static int a(Context context, String str, AdvertAppInfo advertAppInfo) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("tieba://deeplink?")) {
            int c = c(Uri.parse(str), context);
            if (c != 1000) {
                s.dDt().a(advertAppInfo, context);
                return c;
            }
            return 1000;
        }
        s.dDt().a(advertAppInfo, context);
        return 1;
    }

    public static int bc(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || !str.startsWith("tieba://deeplink?")) {
            return 0;
        }
        return c(Uri.parse(str), context);
    }

    public static boolean Rv(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?");
    }

    public static String Rw(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?")) {
            return Uri.parse(str).getQueryParameter("wap");
        }
        return str;
    }

    public static boolean b(AdvertAppInfo advertAppInfo, String str) {
        if (advertAppInfo == null || !advertAppInfo.blE() || TextUtils.isEmpty(str) || !Ru(advertAppInfo.eLw) || str.startsWith("tieba://deeplink?")) {
            return false;
        }
        return j(advertAppInfo);
    }

    public static boolean j(AdvertAppInfo advertAppInfo) {
        Context context;
        Intent bb;
        if (advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.eLw;
        if (TextUtils.isEmpty(str) || (bb = bb((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
            return false;
        }
        try {
            context.startActivity(bb);
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

    public static void dDu() {
        if (!com.baidu.tieba.a.bJg().bJj() && !mRM) {
            mRM = true;
            for (String str : new String[]{"com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic"}) {
                try {
                    Class.forName(str);
                } catch (Throwable th) {
                }
            }
        }
    }

    public static boolean Rx(String str) {
        if (bd(TbadkCoreApplication.getInst(), str)) {
            return Rt(str);
        }
        return false;
    }

    private static boolean bd(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
    }
}
