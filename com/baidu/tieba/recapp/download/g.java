package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.FB()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.aKw;
        if (StringUtils.isNull(str) && advertAppInfo.aKH != null) {
            str = advertAppInfo.aKH.userName;
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
        com.baidu.tbadk.distribute.a.KM().b(advertAppInfo);
        String str2 = advertAppInfo.aKw;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.bor().a(advertAppInfo.aKA, advertAppInfo.aKz, str2, i, h.rL(advertAppInfo.aKA).intValue(), null, true, false, true, advertAppInfo.aKH.userPortrait, downloadStaticsData, advertAppInfo.aKH.userName);
        return true;
    }

    public static final void e(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.FB()) {
            s.e(advertAppInfo);
        } else {
            h.bor().i(advertAppInfo.aKz, advertAppInfo.aKA, true);
        }
    }

    public static final void ao(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, d.j.download_error);
            return;
        }
        File dC = k.dC(str.replace(Constants.DOT, "_") + ".apk");
        if (dC != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(dC, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
