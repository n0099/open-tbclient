package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import java.io.File;
/* loaded from: classes3.dex */
public class h {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.apb()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.bXl;
        if (StringUtils.isNull(str) && advertAppInfo.bXu != null) {
            str = advertAppInfo.bXu.userName;
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
        com.baidu.tbadk.distribute.a.atN().b(advertAppInfo);
        String str2 = advertAppInfo.bXl;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        i.cfY().a(advertAppInfo.bXo, advertAppInfo.bXn, str2, i, i.CB(advertAppInfo.bXo).intValue(), null, true, false, true, advertAppInfo.bXu.userPortrait, downloadStaticsData, advertAppInfo.bXu.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.apb()) {
            s.f(advertAppInfo);
        } else {
            i.cfY().z(advertAppInfo.bXn, advertAppInfo.bXo, true);
        }
    }

    public static final void aK(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, (int) R.string.download_error);
            return;
        }
        File GetFile = m.GetFile(str.replace(DefaultConfig.TOKEN_SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
        if (GetFile != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(GetFile, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
