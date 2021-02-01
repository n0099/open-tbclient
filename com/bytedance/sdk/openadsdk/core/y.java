package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class y {
    private static boolean a(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= height2 * ((long) i);
        }
        return false;
    }

    private static boolean a(Context context) throws Throwable {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        Method method = powerManager != null ? powerManager.getClass().getMethod("isScreenOn", new Class[0]) : null;
        return ((Boolean) (method != null ? method.invoke(powerManager, new Object[0]) : false)).booleanValue();
    }

    private static boolean a(View view) {
        return view != null && view.isShown();
    }

    private static boolean b(View view, int i) {
        return view.getWidth() >= c(view, i) && view.getHeight() >= d(view, i);
    }

    private static int c(View view, int i) {
        if (i == 3) {
            return (int) (ak.c(view.getContext().getApplicationContext()) * 0.7d);
        }
        return 20;
    }

    private static int d(View view, int i) {
        if (i == 3) {
            return ak.d(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int b(View view, int i, int i2) throws Throwable {
        if (!a(view.getContext())) {
            return 4;
        }
        if (!a(view)) {
            return 1;
        }
        if (!b(view, i2)) {
            return 6;
        }
        if (a(view, i)) {
            return 0;
        }
        return 3;
    }

    public static boolean a(View view, int i, int i2) {
        try {
            return b(view, i, i2) == 0;
        } catch (Throwable th) {
            return false;
        }
    }
}
