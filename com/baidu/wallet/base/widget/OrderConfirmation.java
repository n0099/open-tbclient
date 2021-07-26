package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class OrderConfirmation extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24469a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f24470b;

    /* renamed from: c  reason: collision with root package name */
    public View f24471c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24472d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f24473e;

    /* renamed from: f  reason: collision with root package name */
    public View f24474f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24475g;

    /* renamed from: h  reason: collision with root package name */
    public View f24476h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f24477i;
    public View j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public View n;
    public TextView o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderConfirmation(Context context) {
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
        this.f24471c = null;
        this.f24472d = null;
        this.f24473e = null;
        this.f24474f = null;
        this.f24475g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_orderconfirmation"), this);
            this.f24469a = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_back"));
            this.f24470b = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_title"));
            this.f24470b.setImageResource(ResUtils.drawable(getContext(), "wallet_cashdesk_logo"));
            TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_pay_title"));
            this.n = textView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_pay_price"));
            this.o = textView2;
            if (textView2 != null) {
                textView2.setText("");
            }
            this.f24471c = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_layout"));
            this.f24473e = (ImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_icon"));
            this.f24472d = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account"));
            this.f24474f = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account"));
            this.f24475g = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account_value"));
            this.f24476h = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_sp_name"));
            this.f24477i = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_spname_value"));
            View findViewById = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods"));
            this.j = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            TextView textView3 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods_discount_type"));
            this.k = textView3;
            if (textView3 != null) {
                textView3.setText("");
            }
            TextView textView4 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods_discount"));
            this.l = textView4;
            if (textView4 != null) {
                textView4.setText("");
            }
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_account_arrow_icon"));
            this.m = imageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.n == null) {
            return;
        }
        View view = this.f24471c;
        int i2 = (view == null || view.getVisibility() != 0) ? 0 : 1;
        if (this.f24471c != null && this.f24474f.getVisibility() == 0) {
            i2++;
        }
        if (this.f24471c != null && this.j.getVisibility() == 0) {
            i2++;
        }
        if (i2 >= 3) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
        }
    }

    public View getBackButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24469a : (View) invokeV.objValue;
    }

    public View getCouponInfoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void setAccountInfo(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, onClickListener) == null) || this.f24471c == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f24471c.setVisibility(0);
            if (onClickListener != null) {
                this.f24471c.setOnClickListener(onClickListener);
                this.f24473e.setVisibility(0);
            } else {
                this.f24473e.setVisibility(4);
            }
            this.f24472d.setText(str);
            b();
            return;
        }
        this.f24471c.setVisibility(8);
    }

    public void setCouponInfo(CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, charSequence, charSequence2, onClickListener) == null) || (view = this.j) == null || view.getVisibility() == 8) {
            return;
        }
        if (onClickListener != null) {
            this.j.setOnClickListener(onClickListener);
        }
        if (this.k != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.j.setVisibility(0);
                this.k.setText(charSequence);
            } else {
                this.j.setVisibility(8);
                return;
            }
        }
        if (this.l != null) {
            if (!TextUtils.isEmpty(charSequence2)) {
                this.l.setVisibility(0);
                this.l.setVisibility(0);
                this.l.setText(charSequence2);
                this.m.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            this.m.setVisibility(4);
            this.j.setOnClickListener(null);
        }
    }

    public void setDiscountInfoVisiable(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (view = this.j) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void setOrderInfo(CharSequence charSequence) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) || (view = this.f24474f) == null) {
            return;
        }
        if (this.f24475g == null) {
            view.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence)) {
            this.f24474f.setVisibility(0);
            this.f24475g.setText(charSequence);
        } else {
            this.f24474f.setVisibility(8);
        }
    }

    public void setOrderPrice(CharSequence charSequence, CharSequence charSequence2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, charSequence, charSequence2) == null) || this.n == null || TextUtils.isEmpty(charSequence) || (textView = this.o) == null) {
            return;
        }
        textView.setText(charSequence);
        this.n.setVisibility(0);
    }

    public void setSpNameValue(CharSequence charSequence) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, charSequence) == null) || (view = this.f24476h) == null) {
            return;
        }
        if (this.f24477i == null) {
            view.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence)) {
            this.f24476h.setVisibility(0);
            this.f24477i.setText(charSequence);
        } else {
            this.f24476h.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f24470b.setImageUrl(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderConfirmation(Context context, AttributeSet attributeSet) {
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
        this.f24471c = null;
        this.f24472d = null;
        this.f24473e = null;
        this.f24474f = null;
        this.f24475g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        a();
    }
}
