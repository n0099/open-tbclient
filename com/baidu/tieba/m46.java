package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.download.statistics.ApkStaticNetService;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.searchbox.settings.base.UpdatePackageDownloadInfo;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.Date;
/* loaded from: classes7.dex */
public class m46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                String versionName = TbadkCoreApplication.getInst().getVersionName();
                String string = SharedPrefHelper.getInstance().getString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "");
                if (TextUtils.isEmpty(versionName)) {
                    return null;
                }
                if (versionName.equals(string)) {
                    return SharedPrefHelper.getInstance().getString("apk_md5", "");
                }
                SharedPrefHelper.getInstance().putString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, versionName);
                String aPKMd5 = TbMd5.getAPKMd5(TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 0));
                SharedPrefHelper.getInstance().putString("apk_md5", aPKMd5);
                return aPKMd5;
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void b(Context context, VersionData versionData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, versionData) == null) {
            try {
                str = TbMd5.creatSignInt(TbadkCoreApplication.getInst().getContext().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 64));
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.detailException(e);
                str = "-1";
                Intent intent = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
                intent.setFlags(268435488);
                intent.putExtra("id", TbadkCoreApplication.getInst().getContext().getPackageName());
                intent.putExtra("backup", "0");
                intent.putExtra(WebChromeClient.KEY_FUNCTION_NAME, "11");
                Bundle bundle = new Bundle();
                bundle.putInt("versioncode", versionData.getNewVersionCode());
                bundle.putLong("patch_size", JavaTypesHelper.toLong(versionData.getPatchSize(), 0L));
                bundle.putString(UpdatePackageDownloadInfo.JSON_KEY_PATCH_URL, versionData.getPatch());
                bundle.putString(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME, context.getString(R.string.obfuscated_res_0x7f0f029e));
                bundle.putString("packagename", TbadkCoreApplication.getInst().getContext().getPackageName());
                bundle.putString(ApkStaticNetService.STATIC_DOWNLOAD_URL, versionData.getUrl());
                bundle.putString("versionname", versionData.getNewVersion());
                bundle.putString(IMConstants.SHARE_ICON_URL, versionData.getTiebaIconUrl());
                bundle.putString("updatetime", di.getDateStringDay(new Date(System.currentTimeMillis())));
                bundle.putString("size", versionData.getSize());
                bundle.putString("signmd5", str);
                bundle.putString("tj", str + context.getString(R.string.obfuscated_res_0x7f0f029e));
                intent.putExtra("extra_client_downloadinfo", bundle);
                context.startActivity(intent);
            } catch (NumberFormatException e2) {
                BdLog.detailException(e2);
                str = "-1";
                Intent intent2 = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
                intent2.setFlags(268435488);
                intent2.putExtra("id", TbadkCoreApplication.getInst().getContext().getPackageName());
                intent2.putExtra("backup", "0");
                intent2.putExtra(WebChromeClient.KEY_FUNCTION_NAME, "11");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("versioncode", versionData.getNewVersionCode());
                bundle2.putLong("patch_size", JavaTypesHelper.toLong(versionData.getPatchSize(), 0L));
                bundle2.putString(UpdatePackageDownloadInfo.JSON_KEY_PATCH_URL, versionData.getPatch());
                bundle2.putString(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME, context.getString(R.string.obfuscated_res_0x7f0f029e));
                bundle2.putString("packagename", TbadkCoreApplication.getInst().getContext().getPackageName());
                bundle2.putString(ApkStaticNetService.STATIC_DOWNLOAD_URL, versionData.getUrl());
                bundle2.putString("versionname", versionData.getNewVersion());
                bundle2.putString(IMConstants.SHARE_ICON_URL, versionData.getTiebaIconUrl());
                bundle2.putString("updatetime", di.getDateStringDay(new Date(System.currentTimeMillis())));
                bundle2.putString("size", versionData.getSize());
                bundle2.putString("signmd5", str);
                bundle2.putString("tj", str + context.getString(R.string.obfuscated_res_0x7f0f029e));
                intent2.putExtra("extra_client_downloadinfo", bundle2);
                context.startActivity(intent2);
            }
            Intent intent22 = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
            intent22.setFlags(268435488);
            intent22.putExtra("id", TbadkCoreApplication.getInst().getContext().getPackageName());
            intent22.putExtra("backup", "0");
            intent22.putExtra(WebChromeClient.KEY_FUNCTION_NAME, "11");
            Bundle bundle22 = new Bundle();
            bundle22.putInt("versioncode", versionData.getNewVersionCode());
            bundle22.putLong("patch_size", JavaTypesHelper.toLong(versionData.getPatchSize(), 0L));
            bundle22.putString(UpdatePackageDownloadInfo.JSON_KEY_PATCH_URL, versionData.getPatch());
            bundle22.putString(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME, context.getString(R.string.obfuscated_res_0x7f0f029e));
            bundle22.putString("packagename", TbadkCoreApplication.getInst().getContext().getPackageName());
            bundle22.putString(ApkStaticNetService.STATIC_DOWNLOAD_URL, versionData.getUrl());
            bundle22.putString("versionname", versionData.getNewVersion());
            bundle22.putString(IMConstants.SHARE_ICON_URL, versionData.getTiebaIconUrl());
            bundle22.putString("updatetime", di.getDateStringDay(new Date(System.currentTimeMillis())));
            bundle22.putString("size", versionData.getSize());
            bundle22.putString("signmd5", str);
            bundle22.putString("tj", str + context.getString(R.string.obfuscated_res_0x7f0f029e));
            intent22.putExtra("extra_client_downloadinfo", bundle22);
            context.startActivity(intent22);
        }
    }

    public static boolean c(Context context, CombineDownload combineDownload) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, combineDownload)) == null) {
            if (combineDownload == null || efa.b(context, combineDownload.getAppProc()) || TextUtils.isEmpty(combineDownload.getAppUrl())) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && TbSingleton.getInstance().getSyncModel() != null) {
            re5 syncModel = TbSingleton.getInstance().getSyncModel();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), TbSingleton.getInstance().getSyncModel().v(), syncModel.j())));
        }
    }
}
