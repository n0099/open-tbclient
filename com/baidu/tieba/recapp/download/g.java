package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.Dh()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.agg;
        if (StringUtils.isNull(str) && advertAppInfo.agr != null) {
            str = advertAppInfo.agr.userName;
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
        com.baidu.tbadk.distribute.a.Iv().b(advertAppInfo);
        String str2 = advertAppInfo.agg;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.bqi().a(advertAppInfo.agk, advertAppInfo.agj, str2, i, h.ts(advertAppInfo.agk).intValue(), null, true, false, true, advertAppInfo.agr.userPortrait, downloadStaticsData, advertAppInfo.agr.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.Dh()) {
            s.f(advertAppInfo);
        } else {
            h.bqi().i(advertAppInfo.agj, advertAppInfo.agk, true);
        }
    }

    public static final void aD(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, e.j.download_error);
            return;
        }
        File em = com.baidu.tbadk.core.util.l.em(str.replace(".", "_") + ".apk");
        if (em != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(em, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
