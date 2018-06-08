package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.BN()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.adM;
        if (StringUtils.isNull(str) && advertAppInfo.adX != null) {
            str = advertAppInfo.adX.userName;
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
        com.baidu.tbadk.distribute.a.GR().b(advertAppInfo);
        String str2 = advertAppInfo.adM;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.bov().a(advertAppInfo.adQ, advertAppInfo.adP, str2, i, h.sM(advertAppInfo.adQ).intValue(), null, true, false, true, advertAppInfo.adX.userPortrait, downloadStaticsData, advertAppInfo.adX.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.BN()) {
            s.f(advertAppInfo);
        } else {
            h.bov().j(advertAppInfo.adP, advertAppInfo.adQ, true);
        }
    }

    public static final void al(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, d.k.download_error);
            return;
        }
        File dU = com.baidu.tbadk.core.util.l.dU(str.replace(".", "_") + ".apk");
        if (dU != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(dU, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
