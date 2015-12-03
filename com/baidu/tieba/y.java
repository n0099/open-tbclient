package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ah;
import java.util.Date;
/* loaded from: classes.dex */
public class y {
    public static String getTiebaApkMd5() {
        String str = null;
        try {
            String versionName = TbadkCoreApplication.m411getInst().getVersionName();
            String string = com.baidu.tbadk.core.sharedPref.b.tZ().getString("version_name", "");
            if (!TextUtils.isEmpty(versionName)) {
                if (versionName.equals(string)) {
                    str = com.baidu.tbadk.core.sharedPref.b.tZ().getString("apk_md5", "");
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tZ().putString("version_name", versionName);
                    String d = az.d(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.m411getInst().getContext().getPackageName(), 0));
                    com.baidu.tbadk.core.sharedPref.b.tZ().putString("apk_md5", d);
                    str = d;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
        }
        return str;
    }

    public static boolean a(PackageManager packageManager) {
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(8192)) {
            if (packageInfo != null) {
                String str = packageInfo.packageName;
                if (!TextUtils.isEmpty(str) && str.equals("com.baidu.appsearch")) {
                    return packageInfo.versionCode >= 16782633;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, CombineDownload combineDownload) {
        return (combineDownload == null || ah.isInstalledPackage(context, combineDownload.getAppProc()) || TextUtils.isEmpty(combineDownload.getAppUrl())) ? false : true;
    }

    public static void a(Context context, VersionData versionData) {
        String str = "-1";
        try {
            str = az.b(TbadkCoreApplication.m411getInst().getContext().getPackageManager().getPackageInfo(TbadkCoreApplication.m411getInst().getContext().getPackageName(), 64));
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
        } catch (NumberFormatException e2) {
            BdLog.detailException(e2);
        }
        Intent intent = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
        intent.setFlags(268435488);
        intent.putExtra("id", TbadkCoreApplication.m411getInst().getContext().getPackageName());
        intent.putExtra("backup", "0");
        intent.putExtra("func", "11");
        Bundle bundle = new Bundle();
        bundle.putInt("versioncode", versionData.getNewVersionCode());
        bundle.putLong("patch_size", com.baidu.adp.lib.h.b.c(versionData.getPatchSize(), 0L));
        bundle.putString("patch_url", versionData.getPatch());
        bundle.putString("sname", context.getString(n.i.app_name));
        bundle.putString("packagename", TbadkCoreApplication.m411getInst().getContext().getPackageName());
        bundle.putString("downurl", versionData.getUrl());
        bundle.putString("versionname", versionData.getNewVersion());
        bundle.putString("iconurl", versionData.getTiebaIconUrl());
        bundle.putString("updatetime", ax.d(new Date(System.currentTimeMillis())));
        bundle.putString("size", versionData.getSize());
        bundle.putString("signmd5", str);
        bundle.putString("tj", String.valueOf(str) + context.getString(n.i.app_name));
        intent.putExtra("extra_client_downloadinfo", bundle);
        context.startActivity(intent);
    }
}
