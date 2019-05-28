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
        if (adAdSense != null && !adAdSense.ald()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.bDT;
        if (StringUtils.isNull(str) && advertAppInfo.bEc != null) {
            str = advertAppInfo.bEc.userName;
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
        com.baidu.tbadk.distribute.a.aqF().b(advertAppInfo);
        String str2 = advertAppInfo.bDT;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.ceY().a(advertAppInfo.bDW, advertAppInfo.bDV, str2, i, h.CR(advertAppInfo.bDW).intValue(), null, true, false, true, advertAppInfo.bEc.userPortrait, downloadStaticsData, advertAppInfo.bEc.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.ald()) {
            s.f(advertAppInfo);
        } else {
            h.ceY().x(advertAppInfo.bDV, advertAppInfo.bDW, true);
        }
    }

    public static final void aF(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, (int) R.string.download_error);
            return;
        }
        File mZ = m.mZ(str.replace(".", "_") + ".apk");
        if (mZ != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(mZ, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
