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
public class k15 extends g15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k15() {
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

    @Override // com.baidu.tieba.g15
    public void a(@NonNull Context context, @NonNull u05 u05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, u05Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = u05Var.a("is_force_update");
            clientUpdateInfo.mStatus = u05Var.a("status");
            clientUpdateInfo.mReverson = u05Var.a("reverson");
            clientUpdateInfo.mContentUrl = u05Var.a("content_url");
            clientUpdateInfo.mVercode = u05Var.a("version_code");
            clientUpdateInfo.mVername = u05Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = u05Var.a("download_url");
            clientUpdateInfo.mChangelog = u05Var.a("change_log");
            clientUpdateInfo.mSize = u05Var.a("size");
            clientUpdateInfo.mPackageName = u05Var.a("package_name");
            clientUpdateInfo.mSign = u05Var.a("sign");
            clientUpdateInfo.mProdline = u05Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = u05Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = u05Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = u05Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = u05Var.a("patch_size");
            clientUpdateInfo.mIconUrl = u05Var.a("icon_url");
            clientUpdateInfo.mSname = u05Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = u05Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, u05Var.a("apk_md5_rsa"))));
        }
    }
}
