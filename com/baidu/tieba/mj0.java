package com.baidu.tieba;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.tieba.qs0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class mj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(qs0 qs0Var) {
        InterceptResult invokeL;
        qs0.b bVar;
        qs0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qs0Var)) == null) {
            if (qs0Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(qs0Var.f) && TextUtils.isEmpty(qs0Var.d) && (((bVar = qs0Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = qs0Var.h) == null || TextUtils.isEmpty(aVar.a)))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(@Nullable List<MonitorUrl> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        for (MonitorUrl monitorUrl : list) {
            if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.clickUrl)) {
                o41.b(monitorUrl.clickUrl);
            }
        }
    }

    public static void c(@Nullable List<MonitorUrl> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || list == null) {
            return;
        }
        for (MonitorUrl monitorUrl : list) {
            if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.showUrl)) {
                o41.b(monitorUrl.showUrl);
            }
        }
    }

    @ColorInt
    public static int d(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i == i2) {
                return i;
            }
            if (f <= 0.0f) {
                return i;
            }
            if (f >= 1.0f) {
                return i2;
            }
            int red = Color.red(i);
            int blue = Color.blue(i);
            int green = Color.green(i);
            int alpha = Color.alpha(i);
            return Color.argb((int) (alpha + (f * (Color.alpha(i2) - alpha))), (int) (red + ((Color.red(i2) - red) * f)), (int) (green + ((Color.green(i2) - green) * f)), (int) (blue + ((Color.blue(i2) - blue) * f)));
        }
        return invokeCommon.intValue;
    }

    public static String e(@FloatRange(from = 0.0d, to = 1.0d) float f, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f), str})) == null) {
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

    public static int f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ContextCompat.getColor(rk0.b(), i);
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                return ContextCompat.getColor(rk0.b(), i);
            }
        }
        return invokeLI.intValue;
    }

    public static void g(View view2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, view2) == null) && view2 != null && (viewGroup = (ViewGroup) view2.getParent()) != null) {
            viewGroup.removeView(view2);
        }
    }
}
