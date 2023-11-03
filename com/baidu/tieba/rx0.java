package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.t11;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
/* loaded from: classes8.dex */
public class rx0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948136863, "Lcom/baidu/tieba/rx0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948136863, "Lcom/baidu/tieba/rx0;");
                return;
            }
        }
        a = op0.f();
        b = -1;
        c = h31.a(15.0f);
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String c2 = i21.c();
            if (TextUtils.equals(c2, "EMUI") && b(context)) {
                return 1;
            }
            if (TextUtils.equals(c2, "MIUI") && e(context)) {
                return 1;
            }
            if (TextUtils.equals(c2, "OPPO") && c(context)) {
                return 1;
            }
            if ((TextUtils.equals(c2, "VIVO") && d(context)) || "ONEPLUS A6000".equals(Build.MODEL)) {
                return 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            } catch (Exception e) {
                if (!a) {
                    return false;
                }
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                if (((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() != 1) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                if (!a) {
                    return false;
                }
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (a) {
                gg0.e("VideoNotchUtils", "isNotch start");
            }
            if (b == -1) {
                if (Build.VERSION.SDK_INT < 24) {
                    b = 0;
                } else if (b == -1) {
                    b = a(context);
                    gg0.e("VideoNotchUtils", "isNotch from getNotchState");
                }
            }
            if (a) {
                gg0.e("VideoNotchUtils", "isNotch end");
            }
            if (b != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            } catch (Exception e) {
                if (!a) {
                    return false;
                }
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        }
        return invokeL.booleanValue;
    }

    public static void h(@NonNull iv0 iv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, iv0Var) == null) && iv0Var.getContentView() != null && (iv0Var.getContentView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) iv0Var.getContentView();
            viewGroup.setPadding(0, 0, 0, 0);
            viewGroup.setLayoutParams(viewGroup.getLayoutParams());
        }
    }

    public static void i(@NonNull iv0 iv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, iv0Var) == null) && g(gf0.b())) {
            h(iv0Var);
        }
    }

    public static void k(@NonNull iv0 iv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, iv0Var) == null) && g(gf0.b())) {
            j(iv0Var, t11.c.g(), t11.c.g());
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String[] strArr = {"RLI-AN00", "RLI-N29", "TAH-AN00", "TAH-N29", "TAH-AN00m", "RHA-AN00m"};
            if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
                for (int i = 0; i < 6; i++) {
                    if (strArr[i].equalsIgnoreCase(Build.MODEL)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void j(@NonNull iv0 iv0Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65546, null, iv0Var, i, i2) == null) {
            int max = Math.max(i, c);
            int max2 = Math.max(i2, c);
            if (iv0Var.getContentView() != null && (iv0Var.getContentView() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) iv0Var.getContentView();
                viewGroup.setPadding(max, 0, max2, 0);
                viewGroup.setLayoutParams(viewGroup.getLayoutParams());
            }
        }
    }
}
