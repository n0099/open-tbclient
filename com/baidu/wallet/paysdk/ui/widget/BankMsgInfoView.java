package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BorderTipTextView;
@SuppressLint({"NewApi"})
/* loaded from: classes13.dex */
public class BankMsgInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54488b;

    /* renamed from: c  reason: collision with root package name */
    public BorderTipTextView f54489c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f54490d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankMsgInfoView(Context context) {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_bankinfo_view"), this);
            this.f54490d = (ViewGroup) findViewById(ResUtils.id(getContext(), "layout_entity"));
            this.a = (NetImageView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_logo"));
            this.f54488b = (TextView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_txt"));
            this.f54489c = (BorderTipTextView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_coupon_txt"));
        }
    }

    public void hideCouponView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54489c.setVisibility(8);
        }
    }

    public void setBankInfo(String str, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, charSequence) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a.setImageResource(ResUtils.drawable(getContext(), "wallet_base_banklogo_defult"));
                this.a.setImageUrl(str);
                this.a.setVisibility(0);
            }
            this.f54488b.setText(charSequence);
        }
    }

    public void setCouponDesc(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f54489c.setVisibility(0);
                this.f54489c.setText(charSequence, true);
                return;
            }
            this.f54489c.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 0) {
                super.setVisibility(0);
                this.f54490d.setVisibility(0);
                return;
            }
            this.f54490d.setVisibility(4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankMsgInfoView(Context context, AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankMsgInfoView(Context context, AttributeSet attributeSet, int i2) {
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
        a();
    }
}
