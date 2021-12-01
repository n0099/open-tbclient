package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class e extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f51690b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51691c;

    /* renamed from: d  reason: collision with root package name */
    public Context f51692d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
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
        this.a = false;
        this.f51692d = context;
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f51690b = new ImageView(context);
        this.f51691c = new TextView(context);
        this.f51690b.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(context, "ufo_checkbox_default.png")));
        addView(this.f51690b, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(context, 14.0f), com.baidu.ufosdk.f.i.a(context, 14.0f)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(context, 10.0f), 0, 0, 0);
        addView(this.f51691c, layoutParams);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f51691c.setTextColor(-13421773);
        }
    }

    public final void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f51691c.setTextSize(f2);
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f51691c.setText(str);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f51690b.setBackgroundDrawable(z ? new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.f51692d, "ufo_checkbox_checked.png")) : new BitmapDrawable(com.baidu.ufosdk.f.m.a(this.f51692d, "ufo_checkbox_default.png")));
        }
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51691c.getText().toString() : (String) invokeV.objValue;
    }
}
