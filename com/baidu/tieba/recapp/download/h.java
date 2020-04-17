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
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.File;
/* loaded from: classes13.dex */
public class h {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.aRM()) {
            return r.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.dmp;
        if (StringUtils.isNull(str) && advertAppInfo.dmx != null) {
            str = advertAppInfo.dmx.userName;
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
        com.baidu.tbadk.distribute.a.aWD().b(advertAppInfo);
        String str2 = advertAppInfo.dmp;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        i.cNA().a(advertAppInfo.dmr, advertAppInfo.apkUrl, str2, i, i.Js(advertAppInfo.dmr).intValue(), null, true, false, true, advertAppInfo.dmx.userPortrait, downloadStaticsData, advertAppInfo.dmx.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.aRM()) {
            r.f(advertAppInfo);
        } else {
            i.cNA().z(advertAppInfo.apkUrl, advertAppInfo.dmr, true);
        }
    }

    public static final void aY(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, (int) R.string.download_error);
            return;
        }
        File GetFile = m.GetFile(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
        if (GetFile != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
