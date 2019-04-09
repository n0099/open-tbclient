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
        if (adAdSense != null && !adAdSense.age()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.bwI;
        if (StringUtils.isNull(str) && advertAppInfo.bwR != null) {
            str = advertAppInfo.bwR.userName;
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
        com.baidu.tbadk.distribute.a.alC().b(advertAppInfo);
        String str2 = advertAppInfo.bwI;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.bWS().a(advertAppInfo.bwL, advertAppInfo.bwK, str2, i, h.Bv(advertAppInfo.bwL).intValue(), null, true, false, true, advertAppInfo.bwR.userPortrait, downloadStaticsData, advertAppInfo.bwR.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.age()) {
            s.f(advertAppInfo);
        } else {
            h.bWS().u(advertAppInfo.bwK, advertAppInfo.bwL, true);
        }
    }

    public static final void aR(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, d.j.download_error);
            return;
        }
        File lR = m.lR(str.replace(".", "_") + ".apk");
        if (lR != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(lR, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
