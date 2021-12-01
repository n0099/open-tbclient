package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes11.dex */
public class FinanceItemView extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f52584b;

    /* renamed from: c  reason: collision with root package name */
    public MaskTextView f52585c;

    /* renamed from: d  reason: collision with root package name */
    public MaskTextView f52586d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f52587e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinanceItemView(Context context) {
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            removeAllViews();
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_item_view_layout_type_8"), this);
            this.a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "item_view"));
            this.f52584b = (NetImageView) findViewById(ResUtils.id(getContext(), "home_type_8_item_icon"));
            this.f52585c = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_type_8_item_title"));
            this.f52587e = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
            this.f52586d = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_type_8_item_des_1"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getData() == null) {
            return;
        }
        this.f52585c.setMaskText(getData().name);
        NetImageView netImageView = this.f52584b;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().logo);
        if (!TextUtils.isEmpty(getData().value1)) {
            this.f52586d.setMaskText(getData().value1);
            this.f52586d.setVisibility(0);
        } else {
            this.f52586d.setVisibility(8);
        }
        if (!handlePoint() && hasCornor()) {
            this.f52587e.setVisibility(0);
            NetImageView netImageView2 = this.f52587e;
            netImageView2.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().corner_addr);
            return;
        }
        this.f52587e.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            a();
            refresh();
        }
    }

    public void setIconMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52584b.getLayoutParams();
            layoutParams.topMargin = i2;
            this.f52584b.setLayoutParams(layoutParams);
        }
    }

    public void setLayoutPaddingBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            RelativeLayout relativeLayout = this.a;
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), i2);
        }
    }

    public void setTitleMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52585c.getLayoutParams();
            layoutParams.topMargin = i2;
            this.f52585c.setLayoutParams(layoutParams);
        }
    }

    public boolean showValue1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(getData().value1) : invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinanceItemView(Context context, AttributeSet attributeSet) {
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
