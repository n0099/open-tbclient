package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppFileClassifyHelper;
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
        if (adAdSense != null && !adAdSense.GA()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.apr;
        if (StringUtils.isNull(str) && advertAppInfo.apB != null) {
            str = advertAppInfo.apB.userName;
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
        com.baidu.tbadk.distribute.a.LK().b(advertAppInfo);
        String str2 = advertAppInfo.apr;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.buL().a(advertAppInfo.apv, advertAppInfo.apu, str2, i, h.uz(advertAppInfo.apv).intValue(), null, true, false, true, advertAppInfo.apB.userPortrait, downloadStaticsData, advertAppInfo.apB.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.GA()) {
            s.f(advertAppInfo);
        } else {
            h.buL().j(advertAppInfo.apu, advertAppInfo.apv, true);
        }
    }

    public static final void aG(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, e.j.download_error);
            return;
        }
        File eU = com.baidu.tbadk.core.util.l.eU(str.replace(".", BaseRequestAction.SPLITE) + ".apk");
        if (eU != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(eU, intent, context), AiAppFileClassifyHelper.MIME_TYPE_APK);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
