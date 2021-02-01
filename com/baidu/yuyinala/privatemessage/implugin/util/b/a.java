package com.baidu.yuyinala.privatemessage.implugin.util.b;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class a {
    private static DisplayMetrics phq;
    private static DisplayMetrics phr;

    public static void a(DisplayMetrics displayMetrics) {
        phq = displayMetrics;
    }

    public static void hK(Context context) {
        if (emx() == null) {
            initDisplayMetrics(context);
        }
    }

    public static void initDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        a(displayMetrics);
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            throw new AssertionError();
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics2);
        } else {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                displayMetrics2.widthPixels = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                displayMetrics2.heightPixels = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error getting real dimensions for API level < 17", e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Error getting real dimensions for API level < 17", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Error getting real dimensions for API level < 17", e3);
            }
        }
        b(displayMetrics2);
    }

    @Deprecated
    public static DisplayMetrics emw() {
        return phq;
    }

    public static void b(DisplayMetrics displayMetrics) {
        phr = displayMetrics;
    }

    public static DisplayMetrics emx() {
        return phr;
    }
}
