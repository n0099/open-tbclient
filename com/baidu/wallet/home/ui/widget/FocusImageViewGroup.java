package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.baidu.wallet.home.beans.HomeCfgBean;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class FocusImageViewGroup extends BannerFocusImageViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mPageType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusImageViewGroup(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPageType = HomeCfgBean.PAGE_HOME;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup
    public void jump(BannerBaseItemInfo bannerBaseItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bannerBaseItemInfo) == null) {
            com.baidu.wallet.home.a.a().a(getContext(), bannerBaseItemInfo.getStat() != null ? bannerBaseItemInfo.getStat() : bannerBaseItemInfo.getName(), bannerBaseItemInfo.getType(), bannerBaseItemInfo.getLinkAddr(), bannerBaseItemInfo.getPrevlogin(), this.mPageType);
        }
    }

    public void setFocusConfigInfo(BannerBaseItemInfo[] bannerBaseItemInfoArr, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bannerBaseItemInfoArr, str, str2) == null) {
            this.mPageType = str2;
            super.setFocusConfigInfo(bannerBaseItemInfoArr, str);
        }
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup
    public void triggerOnEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            DXMSdkSAUtils.onEventWithValues("newHomeAdClick", Arrays.asList(str));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusImageViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPageType = HomeCfgBean.PAGE_HOME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusImageViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mPageType = HomeCfgBean.PAGE_HOME;
    }
}
