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
        if (adAdSense != null && !adAdSense.yo()) {
            return s.a(context, advertAppInfo, i, downloadStaticsData);
        }
        if (context == null || advertAppInfo == null) {
            return false;
        }
        String str = advertAppInfo.VQ;
        if (StringUtils.isNull(str) && advertAppInfo.Wb != null) {
            str = advertAppInfo.Wb.userName;
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
        com.baidu.tbadk.distribute.a.Dq().b(advertAppInfo);
        String str2 = advertAppInfo.VQ;
        if (StringUtils.isNull(str2)) {
            str2 = str;
        }
        h.bjx().a(advertAppInfo.VU, advertAppInfo.VT, str2, i, h.rR(advertAppInfo.VU).intValue(), null, true, false, true, advertAppInfo.Wb.userPortrait, downloadStaticsData, advertAppInfo.Wb.userName);
        return true;
    }

    public static final void e(AdvertAppInfo advertAppInfo) {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && !adAdSense.yo()) {
            s.e(advertAppInfo);
        } else {
            h.bjx().j(advertAppInfo.VT, advertAppInfo.VU, true);
        }
    }

    public static final void aj(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(context, d.k.download_error);
            return;
        }
        File du = k.du(str.replace(Constants.DOT, "_") + ".apk");
        if (du != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(UtilHelper.getUriFromFile(du, intent, context), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
