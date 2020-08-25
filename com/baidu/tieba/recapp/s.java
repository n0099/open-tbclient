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
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.d.a;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class s {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.dWg;
        if (StringUtils.isNull(str) && advertAppInfo.dWo != null) {
            str = advertAppInfo.dWo.userName;
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
        com.baidu.tbadk.distribute.a.bri().b(advertAppInfo);
        String str2 = advertAppInfo.dWg;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        com.baidu.tieba.recapp.download.e.dnn().a(advertAppInfo.dWi, advertAppInfo.apkUrl, str2, i, com.baidu.tieba.recapp.download.e.Pp(advertAppInfo.dWi).intValue(), null, true, false, true, advertAppInfo.dWo.userPortrait, downloadStaticsData, advertAppInfo.dWo.userName);
        return true;
    }

    public static final void e(AdvertAppInfo advertAppInfo) {
        com.baidu.tieba.recapp.download.e.dnn().B(advertAppInfo.apkUrl, advertAppInfo.dWi, true);
    }

    public static final void aQ(Context context, String str) {
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
        if (context.getPackageManager().getApplicationInfo(str, 8192) != null) {
            return true;
        }
        return false;
    }

    public static boolean as(Activity activity) {
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

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
    }

    public static void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        r.dnh().sendFRS(z, str, str2, str3, list, str4);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        r.dnh().a(z, str, str2, str3, str4, list, str5);
    }

    public static int c(TbPageContext tbPageContext, String str, String str2) {
        if (com.baidu.tieba.a.bzf().bzg() != 1) {
            return h(tbPageContext, str);
        }
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("tieba://deeplink?")) {
            Uri parse = Uri.parse(str);
            if (f(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
                return 1;
            }
            return i(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (!TextUtils.isEmpty(str2)) {
            buildUpon.appendQueryParameter(LegoListActivityConfig.AD_ID, str2);
        }
        return i(tbPageContext, buildUpon.toString()) ? 3 : 0;
    }

    public static int h(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return i(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (f(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
            return 1;
        }
        return i(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    public static int d(TbPageContext tbPageContext, String str, String str2) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("tieba://deeplink?")) {
            Uri parse = Uri.parse(str);
            if (f(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
                return 1;
            }
            return i(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (!TextUtils.isEmpty(str2)) {
            buildUpon.appendQueryParameter(LegoListActivityConfig.AD_ID, str2);
        }
        buildUpon.appendQueryParameter(LegoListActivityConfig.DOWNLOAD_MIDDLE_KEY, "1");
        return i(tbPageContext, buildUpon.toString()) ? 3 : 0;
    }

    private static boolean i(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        g dne = r.dnh().dne();
        if (dne == null) {
            return false;
        }
        if (dne.Dn(str)) {
            dne.a(tbPageContext.getPageActivity(), strArr, true);
            return true;
        }
        return dne.c(tbPageContext.getPageActivity(), strArr);
    }

    public static int aR(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return aT(context, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (f(context, Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
            return 1;
        }
        return aT(context, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    public static int a(Context context, String str, AdvertAppInfo advertAppInfo) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 2;
        }
        if (str.startsWith("tieba://deeplink?") && f(context, Uri.parse(Uri.parse(str).getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
            return 1;
        }
        r.dnh().a(advertAppInfo, context);
        return 2;
    }

    public static boolean aS(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || !str.startsWith("tieba://deeplink?")) {
            return false;
        }
        return f(context, Uri.parse(Uri.parse(str).getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)));
    }

    public static boolean Pk(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?");
    }

    public static String Pl(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("tieba://deeplink?")) {
            return Uri.parse(str).getQueryParameter("wap");
        }
        return str;
    }

    private static boolean aT(Context context, String str) {
        String[] strArr = {str};
        g dne = r.dnh().dne();
        if (dne == null) {
            return false;
        }
        if (dne.Dn(str)) {
            dne.a(context, strArr, true);
            return true;
        }
        return dne.c(context, strArr);
    }
}
