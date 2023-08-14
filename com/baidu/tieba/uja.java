package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.searchbox.download.apkcheck.FkApkInfoSearchRequestKt;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ClientUpdateInfo clientUpdateInfo, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, clientUpdateInfo, str) == null) && clientUpdateInfo != null && !TextUtils.isEmpty(str)) {
            if (!LooperBlockSwitch.getIsOn()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, str)));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_force_update", clientUpdateInfo.mIsForceUpdate);
                jSONObject.put("status", clientUpdateInfo.mStatus);
                jSONObject.put("reverson", clientUpdateInfo.mReverson);
                jSONObject.put("content_url", clientUpdateInfo.mContentUrl);
                jSONObject.put("apk_md5_rsa", str);
                jSONObject.put("version_code", clientUpdateInfo.mVercode);
                jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, clientUpdateInfo.mVername);
                jSONObject.put("download_url", clientUpdateInfo.mDownurl);
                jSONObject.put("change_log", clientUpdateInfo.mChangelog);
                jSONObject.put("size", clientUpdateInfo.mSize);
                jSONObject.put("package_name", clientUpdateInfo.mPackageName);
                jSONObject.put("sign", clientUpdateInfo.mSign);
                jSONObject.put("prod_line", clientUpdateInfo.mProdline);
                jSONObject.put(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5, clientUpdateInfo.mSignMd5);
                jSONObject.put("apk_md5", clientUpdateInfo.mApkMd5);
                jSONObject.put("patch_download_url", clientUpdateInfo.mPatchDownUrl);
                jSONObject.put("patch_size", clientUpdateInfo.mPatchSize);
                jSONObject.put("icon_url", clientUpdateInfo.mIconUrl);
                jSONObject.put(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME, clientUpdateInfo.mSname);
                jSONObject.put("update_time", clientUpdateInfo.mUpdateTime);
            } catch (Exception e) {
                BdLog.e(e);
            }
            YunDialogManager.onShow(TbadkCoreApplication.getInst().getApp(), "lcUpdateDialog", jSONObject);
        }
    }

    public static void b(ke5 ke5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, ke5Var) != null) || ke5Var == null) {
            return;
        }
        VersionData v = ke5Var.v();
        TbadkCoreApplication.getInst().setVersionData(v);
        TbadkCoreApplication.getInst().refreshNewVersion(true);
        if (v.forceUpdate()) {
            if (ke5Var.l() != null && TbadkCoreApplication.getInst().getResumeNum() > 0 && !LooperBlockSwitch.getIsOn()) {
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), v, ke5Var.j())));
                return;
            }
            return;
        }
        Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
        Long valueOf2 = Long.valueOf(new Date().getTime());
        if (valueOf2.longValue() - valueOf.longValue() > 86400000 && v.getStrategy() == 0 && ke5Var.l() != null && TbadkCoreApplication.getInst().getResumeNum() > 0) {
            TbSingleton.getInstance().setSyncModel(ke5Var);
            if (TbSingleton.getInstance().hasPerformedFirstLoginTest() && !LooperBlockSwitch.getIsOn()) {
                TbSingleton.getInstance();
                TbSingleton.setExceptInsertAdDiaShow(true);
                v36.d();
            }
            TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
        }
    }

    public static void c(VersionData versionData, ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{versionData, clientUpdateInfo, str, Boolean.valueOf(z)}) != null) || versionData == null) {
            return;
        }
        TbadkCoreApplication.getInst().setVersionData(versionData);
        TbadkCoreApplication.getInst().refreshNewVersion(true);
        if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
            if (versionData.forceUpdate()) {
                a(clientUpdateInfo, str);
            } else if ((Long.valueOf(new Date().getTime()).longValue() - Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime()).longValue() > 86400000 || z) && versionData.getStrategy() == 0) {
                a(clientUpdateInfo, str);
            }
        }
    }
}
