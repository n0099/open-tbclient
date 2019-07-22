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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.ami()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.bEU;
        if (StringUtils.isNull(str) && advertAppInfo.bFd != null) {
            str = advertAppInfo.bFd.userName;
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
        com.baidu.tbadk.distribute.a.arL().b(advertAppInfo);
        String str2 = advertAppInfo.bEU;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.chQ().a(advertAppInfo.bEX, advertAppInfo.bEW, str2, i, h.DG(advertAppInfo.bEX).intValue(), null, true, false, true, advertAppInfo.bFd.userPortrait, downloadStaticsData, advertAppInfo.bFd.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.ami()) {
            s.f(advertAppInfo);
        } else {
            h.chQ().x(advertAppInfo.bEW, advertAppInfo.bEX, true);
        }
    }

    public static final void aG(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, (int) R.string.download_error);
            return;
        }
        File nk = m.nk(str.replace(".", "_") + ".apk");
        if (nk != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(nk, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
