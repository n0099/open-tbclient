package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class th8 implements h35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public th8(Context context, g35 g35Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, g35Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = context;
    }

    @Override // com.baidu.tieba.h35
    public void a(ShareItem shareItem, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shareItem, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b(shareItem, i);
        }
    }

    public final void b(ShareItem shareItem, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem, i) == null) && this.a != null && shareItem != null) {
            IntentConfig intentConfig = new IntentConfig(this.a);
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(shareItem.v);
            shareEntity.setContent(shareItem.w);
            shareEntity.setReadCount(shareItem.V);
            int i2 = shareItem.Q;
            if (i2 != 2 && i2 != 6 && i2 != 8) {
                z = false;
            } else {
                z = true;
            }
            shareEntity.setIsVideoThread(z);
            shareEntity.setImageUri(shareItem.z);
            shareEntity.canShareBySmartApp = shareItem.s0;
            String str = shareItem.x;
            if (i == 6 && !StringUtils.isNull(shareItem.y)) {
                str = shareItem.y;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.setLocalFile(shareItem.B);
            shareEntity.setLocation(shareItem.F);
            shareEntity.setShareTo(i);
            shareEntity.setStats(shareItem.e());
            shareEntity.setPreferImageToLink(shareItem.h0);
            shareEntity.setTid(shareItem.O);
            shareEntity.setfName(shareItem.t);
            shareEntity.setTypeShareToSmallApp(shareItem.C);
            shareEntity.topic = shareItem.S;
            if (i == 6 && !StringUtils.isNull(shareItem.U)) {
                shareEntity.topic = shareItem.T + shareItem.U;
                shareEntity.setContent("");
            }
            shareEntity.taskCompleteId = shareItem.W;
            shareEntity.diskPicOperate = shareItem.E;
            shareEntity.setExtLiveInfo(shareItem.x0);
            shareEntity.setFromDuXiaoMan(shareItem.m);
            shareEntity.setUserGrowthWeight(shareItem.y0);
            shareEntity.setTopicId(shareItem.z0);
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
            intentConfig.getIntent().putExtras(bundle);
            shareItem.j(true);
            intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
        }
    }
}
