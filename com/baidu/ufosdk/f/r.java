package com.baidu.ufosdk.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public final class r {
    public static void a(Context context, Window window) {
        if (Build.VERSION.SDK_INT < 23 || context == null || window == null) {
            return;
        }
        b(window, 0);
        a(window, true);
    }

    public static void a(Window window, int i) {
        b(window, i);
        a(window, ((int) (((((double) ((((-16711681) | i) >> 16) & 255)) * 0.299d) + (((double) ((((-65281) | i) >> 8) & 255)) * 0.587d)) + (((double) ((i | (-256)) & 255)) * 0.114d))) * 2 > 255);
    }

    public static void a(Window window, boolean z) {
        AppCompatActivity appCompatActivity;
        ActionBar supportActionBar;
        Context context = window.getContext();
        int i = Build.VERSION.SDK_INT;
        window.clearFlags(1024);
        if (i >= 19) {
            int i2 = z ? 13568 : 5376;
            if (l.a() == 2) {
                b(window, z);
            } else if (l.a() == 7) {
                c(window, z);
            } else if (l.a() == 6) {
                if (Build.VERSION.SDK_INT >= 21) {
                    window.addFlags(Integer.MIN_VALUE);
                }
                int i3 = Build.VERSION.SDK_INT;
                i2 |= (i3 < 21 || i3 >= 23) ? i2 : z ? i2 | 16 : i2 & (-17);
            }
            window.getDecorView().setSystemUiVisibility(i2);
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

    public static void b(Window window, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            if ((i & (-16777216)) == 0) {
                window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                return;
            } else {
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                return;
            }
        }
        window.addFlags(Integer.MIN_VALUE);
        if ((i & (-16777216)) == 0) {
            window.setStatusBarColor(0);
        } else if ((~i) != 0) {
            window.setStatusBarColor(i);
        } else {
            if (!(l.a() == 5 || l.a() == 3) || Build.VERSION.SDK_INT >= 23) {
                window.setStatusBarColor(i);
            } else {
                window.setStatusBarColor(-3223858);
            }
        }
    }

    public static boolean b(Window window, boolean z) {
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

    public static boolean c(Window window, boolean z) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
