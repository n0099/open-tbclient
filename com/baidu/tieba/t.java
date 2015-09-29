package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ag;
import java.util.Date;
/* loaded from: classes.dex */
public class t {
    public static String getTiebaApkMd5() {
        String str = null;
        try {
            String versionName = TbadkCoreApplication.m411getInst().getVersionName();
            String string = com.baidu.tbadk.core.sharedPref.b.tu().getString("version_name", "");
            if (!TextUtils.isEmpty(versionName)) {
                if (versionName.equals(string)) {
                    str = com.baidu.tbadk.core.sharedPref.b.tu().getString("apk_md5", "");
                } else {
                    com.baidu.tbadk.core.sharedPref.b.tu().putString("version_name", versionName);
                    String d = at.d(TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.m411getInst().getContext().getPackageName(), 0));
                    com.baidu.tbadk.core.sharedPref.b.tu().putString("apk_md5", d);
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
        return (combineDownload == null || ag.isInstalledPackage(context, combineDownload.getAppProc()) || TextUtils.isEmpty(combineDownload.getAppUrl())) ? false : true;
    }

    public static void a(Context context, VersionData versionData) {
        String str = "-1";
        try {
            str = at.b(TbadkCoreApplication.m411getInst().getContext().getPackageManager().getPackageInfo(TbadkCoreApplication.m411getInst().getContext().getPackageName(), 64));
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
        bundle.putLong("patch_size", com.baidu.adp.lib.g.b.c(versionData.getPatchSize(), 0L));
        bundle.putString("patch_url", versionData.getPatch());
        bundle.putString("sname", context.getString(i.h.app_name));
        bundle.putString("packagename", TbadkCoreApplication.m411getInst().getContext().getPackageName());
        bundle.putString("downurl", versionData.getUrl());
        bundle.putString("versionname", versionData.getNewVersion());
        bundle.putString("iconurl", versionData.getTiebaIconUrl());
        bundle.putString("updatetime", ar.d(new Date(System.currentTimeMillis())));
        bundle.putString("size", versionData.getSize());
        bundle.putString("signmd5", str);
        bundle.putString("tj", String.valueOf(str) + context.getString(i.h.app_name));
        intent.putExtra("extra_client_downloadinfo", bundle);
        context.startActivity(intent);
    }
}
