package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.s;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static final boolean a(Context context, AdvertAppInfo advertAppInfo, int i, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.BT()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.adF;
        if (StringUtils.isNull(str) && advertAppInfo.adQ != null) {
            str = advertAppInfo.adQ.userName;
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
        com.baidu.tbadk.distribute.a.Hf().b(advertAppInfo);
        String str2 = advertAppInfo.adF;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.bnB().a(advertAppInfo.adJ, advertAppInfo.adI, str2, i, h.sL(advertAppInfo.adJ).intValue(), null, true, false, true, advertAppInfo.adQ.userPortrait, downloadStaticsData, advertAppInfo.adQ.userName);
        return true;
    }

    public static final void f(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.BT()) {
            s.f(advertAppInfo);
        } else {
            h.bnB().i(advertAppInfo.adI, advertAppInfo.adJ, true);
        }
    }

    public static final void an(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, f.j.download_error);
            return;
        }
        File dU = com.baidu.tbadk.core.util.l.dU(str.replace(".", "_") + ".apk");
        if (dU != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(dU, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
