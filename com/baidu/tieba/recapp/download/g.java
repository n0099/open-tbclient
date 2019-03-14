package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.agh()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.bwE;
        if (StringUtils.isNull(str) && advertAppInfo.bwN != null) {
            str = advertAppInfo.bwN.userName;
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
        com.baidu.tbadk.distribute.a.alF().b(advertAppInfo);
        String str2 = advertAppInfo.bwE;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.bWW().a(advertAppInfo.bwH, advertAppInfo.bwG, str2, i, h.Bw(advertAppInfo.bwH).intValue(), null, true, false, true, advertAppInfo.bwN.userPortrait, downloadStaticsData, advertAppInfo.bwN.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.agh()) {
            s.f(advertAppInfo);
        } else {
            h.bWW().u(advertAppInfo.bwG, advertAppInfo.bwH, true);
        }
    }

    public static final void aR(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, d.j.download_error);
            return;
        }
        File lQ = m.lQ(str.replace(".", "_") + ".apk");
        if (lQ != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(lQ, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
