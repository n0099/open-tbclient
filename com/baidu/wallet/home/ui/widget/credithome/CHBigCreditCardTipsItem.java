package com.baidu.wallet.home.ui.widget.credithome;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseItemView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes13.dex */
public class CHBigCreditCardTipsItem extends BaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetImageView a;

    /* renamed from: b  reason: collision with root package name */
    public MaskTextView f51221b;

    /* renamed from: c  reason: collision with root package name */
    public View f51222c;

    /* renamed from: d  reason: collision with root package name */
    public HomeCfgResponse.DataIcon f51223d;

    /* renamed from: e  reason: collision with root package name */
    public b f51224e;

    /* renamed from: f  reason: collision with root package name */
    public int f51225f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHBigCreditCardTipsItem(Context context) {
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
        this.f51225f = 24;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_ch_credit_card_tips_item"), this);
            this.a = (NetImageView) findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_item_img"));
            this.f51221b = (MaskTextView) findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_item_text"));
            this.f51222c = findViewById(ResUtils.id(getContext(), "ch_credit_card_tip_divider"));
            this.f51221b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f51225f)});
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (!TextUtils.isEmpty(this.f51223d.icon_link)) {
                this.a.setVisibility(0);
                NetImageView netImageView = this.a;
                netImageView.setImageUrl(this.f51224e.getAndroidPrefix() + this.f51223d.icon_link);
            } else {
                this.a.setVisibility(8);
            }
            this.f51221b.setText(this.f51223d.name);
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

    public void setData(HomeCfgResponse.DataIcon dataIcon, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataIcon, bVar) == null) {
            this.f51223d = dataIcon;
            this.f51224e = bVar;
            a();
            b();
        }
    }

    public void setMaxLength(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f51225f = i2;
        }
    }

    public void setShowDivider(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f51222c.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CHBigCreditCardTipsItem(Context context, AttributeSet attributeSet) {
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
        this.f51225f = 24;
    }
}
