package com.baidu.wallet.base.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import java.util.List;
/* loaded from: classes8.dex */
public class BannerLayoutForAd extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BannerFocusImageViewGroup f60511a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f60512b;

    /* renamed from: c  reason: collision with root package name */
    public BannerBaseItemInfo[] f60513c;

    /* renamed from: d  reason: collision with root package name */
    public int f60514d;

    /* renamed from: e  reason: collision with root package name */
    public int f60515e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerLayoutForAd(Context context) {
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

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_banner_vip"), this);
            this.f60511a = (BannerFocusImageViewGroup) findViewById(ResUtils.id(getContext(), "wallet_banner_gallery"));
            this.f60512b = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_banner_indicators"));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60511a.getLayoutParams();
            int displayWidth = (DisplayUtils.getDisplayWidth(getContext()) - this.f60514d) - this.f60515e;
            int i2 = (displayWidth * Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) / 750;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(displayWidth, i2);
            } else {
                layoutParams.width = displayWidth;
                layoutParams.height = i2;
            }
            this.f60511a.setChildLeft(getPaddingLeft());
            this.f60511a.setLayoutParams(layoutParams);
            this.f60511a.setChildLeft(this.f60514d);
            this.f60511a.setCurrFocusImagePos(new BannerFocusImageViewGroup.CurrFocusImagePos(this) { // from class: com.baidu.wallet.base.widget.banner.BannerLayoutForAd.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BannerLayoutForAd f60516a;

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
                    this.f60516a = this;
                }

                @Override // com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.CurrFocusImagePos
                public void setCurrPos(int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                        int i5 = 0;
                        while (i5 < i4) {
                            if (this.f60516a.f60512b.getChildAt(i5) != null) {
                                this.f60516a.f60512b.getChildAt(i5).setSelected(i5 == i3);
                            }
                            i5++;
                        }
                    }
                }
            });
        }
    }

    public boolean isDataValide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BannerBaseItemInfo[] bannerBaseItemInfoArr = this.f60513c;
            return bannerBaseItemInfoArr != null && bannerBaseItemInfoArr.length > 0;
        }
        return invokeV.booleanValue;
    }

    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f60511a.setFocusConfigInfo(this.f60513c, "");
            int drawable = ResUtils.drawable(getContext(), "wallet_base_indicators");
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 7.0f), DisplayUtils.dip2px(getContext(), 2.0f));
            if (this.f60513c.length > 1) {
                int i2 = 0;
                while (i2 < this.f60513c.length) {
                    View view = new View(getContext());
                    view.setBackgroundResource(drawable);
                    view.setSelected(i2 == 0);
                    this.f60512b.addView(view, layoutParams);
                    layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                    i2++;
                }
                this.f60512b.setVisibility(0);
                return;
            }
            this.f60512b.setVisibility(8);
        }
    }

    public void setConfigData(BannerBaseItemInfo[] bannerBaseItemInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bannerBaseItemInfoArr) == null) {
            this.f60513c = bannerBaseItemInfoArr;
            if (isDataValide()) {
                removeAllViews();
                initView();
                refreshData();
            }
        }
    }

    public void setMaiDianData(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            BannerFocusImageViewGroup bannerFocusImageViewGroup = this.f60511a;
            if (bannerFocusImageViewGroup != null) {
                bannerFocusImageViewGroup.setMaiDianDataKey(str);
            }
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f60511a.setMaindian_public_value(list);
        }
    }

    public void setMarginLeftAndRight(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            this.f60514d = i2;
            this.f60515e = i3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerLayoutForAd(Context context, AttributeSet attributeSet) {
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
