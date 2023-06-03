package com.baidu.tieba;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class z81 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948313718, "Lcom/baidu/tieba/z81;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948313718, "Lcom/baidu/tieba/z81;");
        }
    }

    public static double a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return 1.0d - ((((Color.red(i) * 0.299d) + (Color.green(i) * 0.587d)) + (Color.blue(i) * 0.114d)) / 255.0d);
        }
        return invokeI.doubleValue;
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (a(i) >= 0.3d) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int i = a;
            if (i >= 0) {
                if (i != 1) {
                    return false;
                }
                return true;
            }
            if ("Xiaomi".equals(cl0.c().g(true))) {
                a = 1;
            }
            if (a != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @TargetApi(21)
    public static void d(Window window, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, window, i) == null) && window != null) {
            try {
                if (c()) {
                    if (e(window, !b(i))) {
                        window.setStatusBarColor(i);
                    }
                } else {
                    if (i == -16777216 && window.getNavigationBarColor() == -16777216) {
                        window.clearFlags(Integer.MIN_VALUE);
                    } else {
                        window.addFlags(Integer.MIN_VALUE);
                        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                        if (b(i)) {
                            i2 = systemUiVisibility & (-8193);
                        } else {
                            i2 = systemUiVisibility | 8192;
                        }
                        window.getDecorView().setSystemUiVisibility(i2);
                    }
                    window.setStatusBarColor(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean e(Window window, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, window, z)) == null) {
            if (window != null) {
                Class<?> cls = window.getClass();
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                    Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                    if (z) {
                        method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                    } else {
                        method.invoke(window, 0, Integer.valueOf(i));
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }
}
