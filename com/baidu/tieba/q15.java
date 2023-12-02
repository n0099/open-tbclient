package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.searchbox.download.apkcheck.FkApkInfoSearchRequestKt;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
/* loaded from: classes7.dex */
public class q15 extends m15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q15() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.m15
    public void a(@NonNull Context context, @NonNull a15 a15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, a15Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = a15Var.a("is_force_update");
            clientUpdateInfo.mStatus = a15Var.a("status");
            clientUpdateInfo.mReverson = a15Var.a("reverson");
            clientUpdateInfo.mContentUrl = a15Var.a("content_url");
            clientUpdateInfo.mVercode = a15Var.a("version_code");
            clientUpdateInfo.mVername = a15Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = a15Var.a("download_url");
            clientUpdateInfo.mChangelog = a15Var.a("change_log");
            clientUpdateInfo.mSize = a15Var.a("size");
            clientUpdateInfo.mPackageName = a15Var.a("package_name");
            clientUpdateInfo.mSign = a15Var.a("sign");
            clientUpdateInfo.mProdline = a15Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = a15Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = a15Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = a15Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = a15Var.a("patch_size");
            clientUpdateInfo.mIconUrl = a15Var.a("icon_url");
            clientUpdateInfo.mSname = a15Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = a15Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, a15Var.a("apk_md5_rsa"))));
        }
    }
}
