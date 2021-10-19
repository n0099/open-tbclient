package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.datamodel.WalletBannerItem;
import com.baidu.wallet.home.ui.widget.BaseItemLayout;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.FocusImageViewGroup;
import java.util.List;
/* loaded from: classes8.dex */
public class NHBannerGroup extends BaseItemLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FocusImageViewGroup f61600a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f61601b;

    /* renamed from: c  reason: collision with root package name */
    public WalletBannerItem[] f61602c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHBannerGroup(Context context) {
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
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_banner_layout"), this);
            this.f61600a = (FocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_home_banner_gallery"));
            this.f61601b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_home_banner_indicators"));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61600a.getLayoutParams();
            int displayWidth = DisplayUtils.getDisplayWidth(getContext()) - DisplayUtils.dip2px(getContext(), 34.0f);
            int i2 = (displayWidth * 80) / 341;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(displayWidth, i2);
            } else {
                layoutParams.width = displayWidth;
                layoutParams.height = i2;
            }
            this.f61600a.setChildLeft(DisplayUtils.dip2px(getContext(), 17.0f));
            this.f61600a.setLayoutParams(layoutParams);
            this.f61600a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos(this) { // from class: com.baidu.wallet.home.ui.widget.newhome.NHBannerGroup.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NHBannerGroup f61603a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61603a = this;
                }

                @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
                public void setCurrPos(int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                        int i5 = 0;
                        while (i5 < i4) {
                            if (this.f61603a.f61601b.getChildAt(i5) != null) {
                                this.f61603a.f61601b.getChildAt(i5).setSelected(i5 == i3);
                            }
                            i5++;
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            this.f61602c = dataItemArr;
            this.f61600a.setFocusConfigInfo(dataItemArr, getWalletInterface().getAndroidPrefix(), getWalletInterface().getPageType());
            int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 8.5f), DisplayUtils.dip2px(getContext(), 2.0f));
            if (this.f61602c.length > 1) {
                int i2 = 0;
                while (i2 < this.f61602c.length) {
                    View view = new View(getContext());
                    view.setBackgroundResource(drawable);
                    view.setSelected(i2 == 0);
                    this.f61601b.addView(view, layoutParams);
                    layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                    i2++;
                }
                this.f61601b.setVisibility(0);
                return;
            }
            this.f61601b.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHBannerGroup(Context context, AttributeSet attributeSet) {
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
    }
}
