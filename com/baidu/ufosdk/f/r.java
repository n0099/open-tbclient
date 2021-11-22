package com.baidu.ufosdk.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Window window) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, context, window) == null) || Build.VERSION.SDK_INT < 23 || context == null || window == null) {
            return;
        }
        b(window, 0);
        a(window, true);
    }

    public static void a(Window window, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, window, i2) == null) {
            b(window, i2);
            a(window, ((int) (((((double) ((((-16711681) | i2) >> 16) & 255)) * 0.299d) + (((double) ((((-65281) | i2) >> 8) & 255)) * 0.587d)) + (((double) ((i2 | (-256)) & 255)) * 0.114d))) * 2 > 255);
        }
    }

    public static void a(Window window, boolean z) {
        AppCompatActivity appCompatActivity;
        ActionBar supportActionBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, window, z) == null) {
            Context context = window.getContext();
            int i2 = Build.VERSION.SDK_INT;
            window.clearFlags(1024);
            if (i2 >= 19) {
                int i3 = z ? 13568 : 5376;
                if (l.a() == 2) {
                    b(window, z);
                } else if (l.a() == 7) {
                    c(window, z);
                } else if (l.a() == 6) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        window.addFlags(Integer.MIN_VALUE);
                    }
                    int i4 = Build.VERSION.SDK_INT;
                    i3 |= (i4 < 21 || i4 >= 23) ? i3 : z ? i3 | 16 : i3 & (-17);
                }
                window.getDecorView().setSystemUiVisibility(i3);
                return;
            }
            for (Context context2 = context; context2 != null; context2 = ((ContextThemeWrapper) context2).getBaseContext()) {
                if (context2 instanceof AppCompatActivity) {
                    appCompatActivity = (AppCompatActivity) context2;
                    break;
                } else {
                    if (!(context2 instanceof ContextThemeWrapper)) {
                        break;
                    }
                }
            }
            appCompatActivity = null;
            if (appCompatActivity != null && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
                supportActionBar.setShowHideAnimationEnabled(false);
                supportActionBar.show();
            }
            if (context instanceof Activity) {
                ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
    }

    public static void b(Window window, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, window, i2) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                if ((i2 & (-16777216)) == 0) {
                    window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    return;
                } else {
                    window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    return;
                }
            }
            window.addFlags(Integer.MIN_VALUE);
            if ((i2 & (-16777216)) == 0) {
                window.setStatusBarColor(0);
            } else if ((~i2) != 0) {
                window.setStatusBarColor(i2);
            } else {
                if (!(l.a() == 5 || l.a() == 3) || Build.VERSION.SDK_INT >= 23) {
                    window.setStatusBarColor(i2);
                } else {
                    window.setStatusBarColor(-3223858);
                }
            }
        }
    }

    public static boolean b(Window window, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, window, z)) == null) {
            if (window != null) {
                Class<?> cls = window.getClass();
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                    Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                    if (z) {
                        method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                    } else {
                        method.invoke(window, 0, Integer.valueOf(i2));
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean c(Window window, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, window, z)) == null) {
            if (window != null) {
                try {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                    Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    int i2 = declaredField.getInt(null);
                    int i3 = declaredField2.getInt(attributes);
                    declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
                    window.setAttributes(attributes);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }
}
