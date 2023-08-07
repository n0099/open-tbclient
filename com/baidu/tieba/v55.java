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
/* loaded from: classes8.dex */
public class v55 extends r55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v55() {
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

    @Override // com.baidu.tieba.r55
    public void a(@NonNull Context context, @NonNull j55 j55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, j55Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = j55Var.a("is_force_update");
            clientUpdateInfo.mStatus = j55Var.a("status");
            clientUpdateInfo.mReverson = j55Var.a("reverson");
            clientUpdateInfo.mContentUrl = j55Var.a("content_url");
            clientUpdateInfo.mVercode = j55Var.a("version_code");
            clientUpdateInfo.mVername = j55Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = j55Var.a("download_url");
            clientUpdateInfo.mChangelog = j55Var.a("change_log");
            clientUpdateInfo.mSize = j55Var.a("size");
            clientUpdateInfo.mPackageName = j55Var.a("package_name");
            clientUpdateInfo.mSign = j55Var.a("sign");
            clientUpdateInfo.mProdline = j55Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = j55Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = j55Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = j55Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = j55Var.a("patch_size");
            clientUpdateInfo.mIconUrl = j55Var.a("icon_url");
            clientUpdateInfo.mSname = j55Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = j55Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, j55Var.a("apk_md5_rsa"))));
        }
    }
}
