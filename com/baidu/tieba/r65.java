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
public class r65 extends n65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r65() {
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

    @Override // com.baidu.tieba.n65
    public void a(@NonNull Context context, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, f65Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = f65Var.a("is_force_update");
            clientUpdateInfo.mStatus = f65Var.a("status");
            clientUpdateInfo.mReverson = f65Var.a("reverson");
            clientUpdateInfo.mContentUrl = f65Var.a("content_url");
            clientUpdateInfo.mVercode = f65Var.a("version_code");
            clientUpdateInfo.mVername = f65Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = f65Var.a("download_url");
            clientUpdateInfo.mChangelog = f65Var.a("change_log");
            clientUpdateInfo.mSize = f65Var.a("size");
            clientUpdateInfo.mPackageName = f65Var.a("package_name");
            clientUpdateInfo.mSign = f65Var.a("sign");
            clientUpdateInfo.mProdline = f65Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = f65Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = f65Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = f65Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = f65Var.a("patch_size");
            clientUpdateInfo.mIconUrl = f65Var.a("icon_url");
            clientUpdateInfo.mSname = f65Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = f65Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, f65Var.a("apk_md5_rsa"))));
        }
    }
}
