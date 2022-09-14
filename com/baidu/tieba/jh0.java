package com.baidu.tieba;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ap0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ap0 ap0Var) {
        InterceptResult invokeL;
        ap0.b bVar;
        ap0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ap0Var)) == null) {
            if (ap0Var == null) {
                return false;
            }
            return (TextUtils.isEmpty(ap0Var.f) && TextUtils.isEmpty(ap0Var.d) && ((bVar = ap0Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = ap0Var.h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static int b(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i != i2 && f > 0.0f) {
                if (f >= 1.0f) {
                    return i2;
                }
                int red = Color.red(i);
                int blue = Color.blue(i);
                int green = Color.green(i);
                int alpha = Color.alpha(i);
                return Color.argb((int) (alpha + (f * (Color.alpha(i2) - alpha))), (int) (red + ((Color.red(i2) - red) * f)), (int) (green + ((Color.green(i2) - green) * f)), (int) (blue + ((Color.blue(i2) - blue) * f)));
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public static String c(@FloatRange(from = 0.0d, to = 1.0d) float f, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f), str})) == null) {
            String hexString = Integer.toHexString(Math.round(f * 255.0f));
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            if (hexString.length() != 2) {
                return "";
            }
            return "#" + hexString + str;
        }
        return (String) invokeCommon.objValue;
    }

    public static int d(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ContextCompat.getColor(mi0.b(), i);
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                return ContextCompat.getColor(mi0.b(), i);
            }
        }
        return invokeLI.intValue;
    }

    public static void e(View view2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2) == null) || view2 == null || (viewGroup = (ViewGroup) view2.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view2);
    }
}
