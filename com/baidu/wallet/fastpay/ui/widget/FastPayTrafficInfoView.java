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
/* loaded from: classes13.dex */
public class FastPayTrafficInfoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f51285b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51286c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51287d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51288e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51289f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51290g;

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
            this.f51290g = (TextView) findViewById(ResUtils.id(getContext(), "wallet_to_buy"));
            this.a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_current_price"));
            this.f51285b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_formal_price"));
            this.f51286c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_area"));
            this.f51287d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_available_time"));
            this.f51288e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_discount_info"));
            this.f51289f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_traffic_info_hui_des"));
        }
    }

    public void setActualPrice(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.setText(str);
    }

    public void setDiscountInfo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.f51288e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f51288e.setVisibility(0);
        this.f51288e.setText(str);
    }

    public void setHuiDes(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f51289f == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f51289f.setText(str);
        this.f51289f.setVisibility(0);
    }

    public void setOnBuyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f51290g.setOnClickListener(onClickListener);
        }
    }

    public void setOriginalmalPrice(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f51285b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f51285b.setText(str);
        this.f51285b.getPaint().setFlags(17);
    }

    public void setUsePeriod(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f51287d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f51287d.setText(str);
    }

    public void setUseProvince(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f51286c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f51286c.setVisibility(0);
        TextView textView = this.f51286c;
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
