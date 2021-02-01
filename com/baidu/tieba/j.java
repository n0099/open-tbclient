package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.tbadkCore.z;
import com.tencent.connect.common.Constants;
import java.util.Date;
/* loaded from: classes.dex */
public class j {
    public static String getTiebaApkMd5() {
        String str = null;
        try {
            String versionName = TbadkCoreApplication.getInst().getVersionName();
            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.VERSION_NAME, "");
            if (!TextUtils.isEmpty(versionName)) {
                if (versionName.equals(string)) {
                    str = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.APK_MD5, "");
                } else {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.VERSION_NAME, versionName);
                    String aPKMd5 = aw.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 0));
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.APK_MD5, aPKMd5);
                    str = aPKMd5;
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
        return (combineDownload == null || z.isInstalledPackage(context, combineDownload.getAppProc()) || TextUtils.isEmpty(combineDownload.getAppUrl())) ? false : true;
    }

    public static void a(Context context, VersionData versionData) {
        String str = "-1";
        try {
            str = aw.creatSignInt(TbadkCoreApplication.getInst().getContext().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 64));
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
        } catch (NumberFormatException e2) {
            BdLog.detailException(e2);
        }
        Intent intent = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
        intent.setFlags(268435488);
        intent.putExtra("id", TbadkCoreApplication.getInst().getContext().getPackageName());
        intent.putExtra(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, "0");
        intent.putExtra("func", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
        Bundle bundle = new Bundle();
        bundle.putInt("versioncode", versionData.getNewVersionCode());
        bundle.putLong("patch_size", com.baidu.adp.lib.f.b.toLong(versionData.getPatchSize(), 0L));
        bundle.putString("patch_url", versionData.getPatch());
        bundle.putString("sname", context.getString(R.string.app_name));
        bundle.putString("packagename", TbadkCoreApplication.getInst().getContext().getPackageName());
        bundle.putString("downurl", versionData.getUrl());
        bundle.putString("versionname", versionData.getNewVersion());
        bundle.putString("iconurl", versionData.getTiebaIconUrl());
        bundle.putString("updatetime", au.getDateStringDay(new Date(System.currentTimeMillis())));
        bundle.putString(TiebaInitialize.LogFields.SIZE, versionData.getSize());
        bundle.putString("signmd5", str);
        bundle.putString("tj", str + context.getString(R.string.app_name));
        intent.putExtra("extra_client_downloadinfo", bundle);
        context.startActivity(intent);
    }
}
