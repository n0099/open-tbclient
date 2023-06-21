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
public class o65 extends k65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o65() {
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

    @Override // com.baidu.tieba.k65
    public void a(@NonNull Context context, @NonNull c65 c65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, c65Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = c65Var.a("is_force_update");
            clientUpdateInfo.mStatus = c65Var.a("status");
            clientUpdateInfo.mReverson = c65Var.a("reverson");
            clientUpdateInfo.mContentUrl = c65Var.a("content_url");
            clientUpdateInfo.mVercode = c65Var.a("version_code");
            clientUpdateInfo.mVername = c65Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = c65Var.a("download_url");
            clientUpdateInfo.mChangelog = c65Var.a("change_log");
            clientUpdateInfo.mSize = c65Var.a("size");
            clientUpdateInfo.mPackageName = c65Var.a("package_name");
            clientUpdateInfo.mSign = c65Var.a("sign");
            clientUpdateInfo.mProdline = c65Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = c65Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = c65Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = c65Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = c65Var.a("patch_size");
            clientUpdateInfo.mIconUrl = c65Var.a("icon_url");
            clientUpdateInfo.mSname = c65Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = c65Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, c65Var.a("apk_md5_rsa"))));
        }
    }
}
