package com.baidu.tieba;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public class tua {
    public static /* synthetic */ Interceptable $ic;
    public static final ThemeElement a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) ? (i & 16777215) | (((int) ((i >>> 24) * f)) << 24) : invokeCommon.intValue;
    }

    public static boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? i == Integer.MAX_VALUE : invokeI.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195081, "Lcom/baidu/tieba/tua;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195081, "Lcom/baidu/tieba/tua;");
                return;
            }
        }
        ThemeElement.Builder builder = new ThemeElement.Builder();
        builder.common_color = "#FF614EC2";
        builder.dark_color = "#FF614EC2";
        builder.light_color = "#FF614EC2";
        builder.pattern_image = "http://imgsrc.baidu.com/forum/pic/item/00a8540828381f3028c4e2d1a6014c086f06f075.jpg";
        builder.font_color = "#FFFFFFFF";
        a = builder.build(false);
    }

    @NonNull
    public static ThemeElement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (ThemeElement) invokeV.objValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            float[] fArr = new float[3];
            Color.colorToHSV(i, fArr);
            if ((fArr[0] < 0.0f || fArr[0] >= 60.0f) && ((fArr[0] < 120.0f || fArr[0] >= 180.0f) && fArr[0] < 240.0f && fArr[0] >= 300.0f)) {
                fArr[0] = fArr[0] + 15.0f;
            } else {
                fArr[0] = fArr[0] - 15.0f;
            }
            return Color.HSVToColor(fArr);
        }
        return invokeI.intValue;
    }

    public static int d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            if (context != null && context.getResources() != null) {
                return context.getResources().getIdentifier(str, "color", context.getPackageName());
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str == null) {
                return Integer.MAX_VALUE;
            }
            if (str.length() != 0) {
                try {
                    if (!str.startsWith("#")) {
                        str = "#" + str;
                    }
                } catch (Exception unused) {
                    return Integer.MAX_VALUE;
                }
            }
            return Color.parseColor(str);
        }
        return invokeL.intValue;
    }
}
