package com.baidu.wallet.fastpay.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class FastPayTrafficInfoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f25075a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25076b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25077c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25078d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25079e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25080f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25081g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastPayTrafficInfoView(Context context) {
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_fp_traffic_info_item"), this);
            this.f25081g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
            this.f25075a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
            this.f25076b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
            this.f25077c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
            this.f25078d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
            this.f25079e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
            this.f25080f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
        }
    }

    public void setActualPrice(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f25075a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25075a.setText(str);
    }

    public void setDiscountInfo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f25079e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25079e.setVisibility(0);
        this.f25079e.setText(str);
    }

    public void setHuiDes(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f25080f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25080f.setText(str);
        this.f25080f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f25081g.setOnClickListener(onClickListener);
        }
    }

    public void setOriginalmalPrice(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f25076b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25076b.setText(str);
        this.f25076b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f25078d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25078d.setText(str);
    }

    public void setUseProvince(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f25077c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25077c.setVisibility(0);
        TextView textView = this.f25077c;
        textView.setText(str + "，");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastPayTrafficInfoView(Context context, AttributeSet attributeSet) {
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
    public FastPayTrafficInfoView(Context context, AttributeSet attributeSet, int i2) {
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
