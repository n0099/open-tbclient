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
/* loaded from: classes6.dex */
public class k65 extends g65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k65() {
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

    @Override // com.baidu.tieba.g65
    public void a(@NonNull Context context, @NonNull u55 u55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, u55Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = u55Var.a("is_force_update");
            clientUpdateInfo.mStatus = u55Var.a("status");
            clientUpdateInfo.mReverson = u55Var.a("reverson");
            clientUpdateInfo.mContentUrl = u55Var.a("content_url");
            clientUpdateInfo.mVercode = u55Var.a("version_code");
            clientUpdateInfo.mVername = u55Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = u55Var.a("download_url");
            clientUpdateInfo.mChangelog = u55Var.a("change_log");
            clientUpdateInfo.mSize = u55Var.a("size");
            clientUpdateInfo.mPackageName = u55Var.a("package_name");
            clientUpdateInfo.mSign = u55Var.a("sign");
            clientUpdateInfo.mProdline = u55Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = u55Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = u55Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = u55Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = u55Var.a("patch_size");
            clientUpdateInfo.mIconUrl = u55Var.a("icon_url");
            clientUpdateInfo.mSname = u55Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = u55Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, u55Var.a("apk_md5_rsa"))));
        }
    }
}
