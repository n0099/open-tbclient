package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.wc0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class tc0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948176264, "Lcom/baidu/tieba/tc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948176264, "Lcom/baidu/tieba/tc0;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String a2 = qc0.a();
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            return a2.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI);
        }
        return invokeV.booleanValue;
    }

    public static void b(boolean z, Activity activity) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65538, null, z, activity) == null) && activity != null && activity.getWindow() != null) {
            if (Build.VERSION.SDK_INT < 23) {
                wc0.b a2 = wc0.a(activity);
                a2.c(!z);
                a2.b();
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            if (decorView != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z) {
                    i = systemUiVisibility & (-8193);
                } else {
                    if (f()) {
                        Window window = activity.getWindow();
                        window.addFlags(Integer.MIN_VALUE);
                        window.clearFlags(67108864);
                    }
                    i = systemUiVisibility | 8192;
                }
                decorView.setSystemUiVisibility(i);
            }
        }
    }

    public static void h(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, activity, z) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19 && activity != null) {
                if (i >= 23) {
                    m(activity, z);
                    wc0.a(activity).b();
                    a = true;
                    return;
                } else if (!wc0.a(activity).b()) {
                    a = false;
                    return;
                } else if (Build.VERSION.SDK_INT < 21) {
                    i(activity);
                    a = true;
                    return;
                } else {
                    j(activity);
                    c(activity, true);
                    a = true;
                    return;
                }
            }
            a = false;
        }
    }

    public static void c(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65539, null, activity, z) == null) && activity != null && Build.VERSION.SDK_INT >= 28) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            window.setAttributes(attributes);
        }
    }

    public static void m(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, activity, z) == null) {
            k(activity, z, true);
        }
    }

    public static float d(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static void g(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, activity) == null) {
            h(activity, false);
            b(true, activity);
        }
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, activity) == null) {
            k(activity, false, false);
        }
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
            int i = 0;
            if (identifier > 0) {
                try {
                    i = context.getResources().getDimensionPixelSize(identifier);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i == 0) {
                return (int) (d(context) * 25.0f);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void i(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, activity) != null) || activity == null) {
            return;
        }
        boolean z = false;
        int i = -1;
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            if (field != null) {
                i = field.getInt(null);
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            activity.getWindow().setFlags(i, i);
        }
    }

    public static void k(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || activity == null) {
            return;
        }
        l(activity.getWindow(), z, z2);
    }

    public static void l(Window window, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{window, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || window == null) {
            return;
        }
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS");
            Field field2 = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            Field field3 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN");
            Field field4 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_STABLE");
            Method method = window.getClass().getMethod("setStatusBarColor", Integer.TYPE);
            Method method2 = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
            if (field != null && field2 != null && field3 != null && field4 != null && method != null && method2 != null) {
                int i = field.getInt(null);
                int i2 = field2.getInt(null);
                int i3 = field3.getInt(null);
                int i4 = field4.getInt(null);
                window.clearFlags(i2);
                if (z2) {
                    Field field5 = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR");
                    if (field5 != null) {
                        window.getDecorView().setSystemUiVisibility(field5.getInt(null) | i3);
                    }
                } else {
                    method2.invoke(window.getDecorView(), Integer.valueOf(i3 | i4));
                }
                window.addFlags(i);
                method.invoke(window, 0);
                if (z) {
                    Field field6 = WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN");
                    Method method3 = window.getClass().getMethod("setFlags", Integer.TYPE, Integer.TYPE);
                    int i5 = field6.getInt(null);
                    method3.invoke(window, Integer.valueOf(i5), Integer.valueOf(i5));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
