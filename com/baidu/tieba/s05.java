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
public class s05 extends o05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s05() {
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

    @Override // com.baidu.tieba.o05
    public void a(@NonNull Context context, @NonNull c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, c05Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = c05Var.a("is_force_update");
            clientUpdateInfo.mStatus = c05Var.a("status");
            clientUpdateInfo.mReverson = c05Var.a("reverson");
            clientUpdateInfo.mContentUrl = c05Var.a("content_url");
            clientUpdateInfo.mVercode = c05Var.a("version_code");
            clientUpdateInfo.mVername = c05Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = c05Var.a("download_url");
            clientUpdateInfo.mChangelog = c05Var.a("change_log");
            clientUpdateInfo.mSize = c05Var.a("size");
            clientUpdateInfo.mPackageName = c05Var.a("package_name");
            clientUpdateInfo.mSign = c05Var.a("sign");
            clientUpdateInfo.mProdline = c05Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = c05Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = c05Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = c05Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = c05Var.a("patch_size");
            clientUpdateInfo.mIconUrl = c05Var.a("icon_url");
            clientUpdateInfo.mSname = c05Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = c05Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, c05Var.a("apk_md5_rsa"))));
        }
    }
}
