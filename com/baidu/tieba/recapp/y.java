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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.distribute.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private static final HashMap<Integer, Integer> eZg = new HashMap<>();
    private static final String[] eZh = {"exp_8_4", "exp_8_3", "exp_8_2"};

    static {
        eZg.put(1, 1001);
        eZg.put(2, 1002);
        eZg.put(3, 1003);
    }

    public static String pi(String str) {
        int intValue;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 != eZh.length) {
                        int optInt = jSONObject.optInt(eZh[i2]);
                        if (optInt <= 0 || !eZg.containsKey(Integer.valueOf(optInt)) || (intValue = eZg.get(Integer.valueOf(optInt)).intValue()) <= 1000) {
                            i = i2 + 1;
                        } else {
                            jSONObject.put("card_type", intValue);
                            return jSONObject.toString();
                        }
                    } else {
                        return str;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return str;
            }
        } else {
            return str;
        }
    }

    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.TS;
        if (StringUtils.isNull(str) && advertAppInfo.Uc != null) {
            str = advertAppInfo.Uc.userName;
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
        a.CX().b(advertAppInfo);
        String str2 = advertAppInfo.TS;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        com.baidu.tieba.recapp.c.a.aZT().a(advertAppInfo.TW, advertAppInfo.TV, str2, i, com.baidu.tieba.recapp.c.a.pk(advertAppInfo.TW).intValue(), null, true, false, true, advertAppInfo.Uc.userPortrait, downloadStaticsData, advertAppInfo.Uc.userName);
        return true;
    }

    public static final void e(AdvertAppInfo advertAppInfo) {
        com.baidu.tieba.recapp.c.a.aZT().j(advertAppInfo.TV, advertAppInfo.TW, true);
    }

    public static final void ap(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            k.showToast(context, w.l.download_error);
            return;
        }
        File cX = l.cX(String.valueOf(str.replace(".", "_")) + ".apk");
        if (cX != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(cX, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
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

    public static boolean x(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean aE = ae.aE(activity);
        if (activity.getApplicationInfo().targetSdkVersion < 23 && Environment.getExternalStorageState().equals("unmounted")) {
            return false;
        }
        return aE;
    }

    public static List<String> bJ(Context context) {
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
            tbImageView.setDefaultErrorResource(w.g.icon_advert);
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
            tbImageView.setDefaultErrorResource(w.g.icon_advert);
            tbImageView.setDefaultResource(0);
            tbImageView.setDefaultBgResource(0);
            tbImageView.c(str, 10, false);
            tbImageView.setEvent(new z(tbImageView, i, f));
        }
    }

    public static void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        v.aZP().sendFRS(z, str, str2, str3, list, str4);
    }

    public static void sendPB(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        v.aZP().a(z, str, str2, str3, str4, list, str5);
    }
}
