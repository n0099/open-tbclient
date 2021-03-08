package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.t;
import java.io.File;
/* loaded from: classes7.dex */
public class h {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.bwh()) {
            return t.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.eMV;
        if (StringUtils.isNull(str) && advertAppInfo.eNd != null) {
            str = advertAppInfo.eNd.userName;
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
        com.baidu.tbadk.distribute.a.bAX().b(advertAppInfo);
        String str2 = advertAppInfo.eMV;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        i.dDN().a(advertAppInfo.eMX, advertAppInfo.apkUrl, str2, i, i.RJ(advertAppInfo.eMX).intValue(), null, true, false, true, advertAppInfo.eNd.userPortrait, downloadStaticsData, advertAppInfo.eNd.userName);
        return true;
    }

    public static final void i(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.bwh()) {
            t.i(advertAppInfo);
        } else {
            i.dDN().F(advertAppInfo.apkUrl, advertAppInfo.eMX, true);
        }
    }

    public static final void installApp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, R.string.download_error);
            return;
        }
        File GetFile = o.GetFile(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
        if (GetFile != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
