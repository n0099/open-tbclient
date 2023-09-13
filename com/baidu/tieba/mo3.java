package com.baidu.tieba;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class mo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979352, "Lcom/baidu/tieba/mo3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979352, "Lcom/baidu/tieba/mo3;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, context, drawable, mode, i) == null) && context != null && drawable != null) {
            int d = d(context);
            if (i >= 0 && i < 255) {
                d = Color.argb((Color.alpha(d) * i) / 255, Color.red(d), Color.green(d), Color.blue(d));
            }
            drawable.setColorFilter(d, mode);
        }
    }

    public static void b(Context context, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, drawable) == null) {
            c(context, drawable, 255);
        }
    }

    public static void c(Context context, Drawable drawable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, context, drawable, i) == null) {
            a(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
        }
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return context.getResources().getColor(R.color.obfuscated_res_0x7f060470);
        }
        return invokeL.intValue;
    }
}
