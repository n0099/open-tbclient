package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class ja0 {
    public static /* synthetic */ Interceptable $ic;
    public static final ja0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947876432, "Lcom/baidu/tieba/ja0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947876432, "Lcom/baidu/tieba/ja0;");
                return;
            }
        }
        a = new ja0();
    }

    public ja0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final Drawable a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, str2)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{uc0.f().a(context, str, "color_gradient_1"), uc0.f().a(context, str, "color_gradient_2")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            return gradientDrawable;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public final Drawable b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            float b = da0.b(context, 7.0f);
            gradientDrawable.setCornerRadii(new float[]{b, b, b, b, b, b, b, b});
            gradientDrawable.setColors(new int[]{uc0.f().a(context, str, "color_F5F5F53"), uc0.f().a(context, str, "color_F5F5F53")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            return gradientDrawable;
        }
        return (Drawable) invokeLL.objValue;
    }

    public final Drawable c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            float b = da0.b(context, 18.0f);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, b, b, b, b});
            gradientDrawable.setColors(new int[]{uc0.f().a(context, str, "color_main_bg"), uc0.f().a(context, str, "color_main_bg")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            return gradientDrawable;
        }
        return (Drawable) invokeLL.objValue;
    }

    public final Drawable d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, str, str2)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{uc0.f().a(context, str, "color_gradient_2"), uc0.f().a(context, str, "color_gradient_1")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            return gradientDrawable;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public final Drawable e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            float b = da0.b(context, 7.0f);
            gradientDrawable.setCornerRadii(new float[]{b, b, b, b, b, b, b, b});
            gradientDrawable.setColors(new int[]{uc0.f().a(context, str, "color_FF33552"), uc0.f().a(context, str, "color_FF33552")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            return gradientDrawable;
        }
        return (Drawable) invokeLL.objValue;
    }
}
