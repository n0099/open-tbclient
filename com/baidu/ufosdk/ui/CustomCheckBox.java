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
import com.baidu.ufosdk.p1;
/* loaded from: classes9.dex */
public class CustomCheckBox extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public boolean c;
    public Context d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCheckBox(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = context;
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        a(context, z);
    }

    public final void a(Context context, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            this.a = new ImageView(context);
            this.b = new TextView(context);
            if (z) {
                str = "ufo_checkbox_default_night.png";
            } else {
                str = "ufo_checkbox_default.png";
            }
            this.a.setBackgroundDrawable(new BitmapDrawable(p1.b(context, str)));
            addView(this.a, new LinearLayout.LayoutParams(p1.a(context, 14.0f), p1.a(context, 14.0f)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(p1.a(context, 10.0f), 0, 0, 0);
            addView(this.b, layoutParams);
        }
    }

    public void a(boolean z, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                Context context = this.d;
                if (z2) {
                    str2 = "ufo_checkbox_checked_night.png";
                } else {
                    str2 = "ufo_checkbox_checked.png";
                }
                this.a.setBackgroundDrawable(new BitmapDrawable(p1.b(context, str2)));
                return;
            }
            Context context2 = this.d;
            if (z2) {
                str = "ufo_checkbox_default_night.png";
            } else {
                str = "ufo_checkbox_default.png";
            }
            this.a.setBackgroundDrawable(new BitmapDrawable(p1.b(context2, str)));
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.getText().toString();
        }
        return (String) invokeV.objValue;
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b.setText(str);
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b.setTextColor(i);
        }
    }

    public void setTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.b.setTextSize(1, f);
        }
    }
}
