package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class y {
    public static boolean a(View view, int i2) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= ((long) i2) * height2;
        }
        return false;
    }

    public static boolean b(View view, int i2) {
        return view.getWidth() >= c(view, i2) && view.getHeight() >= d(view, i2);
    }

    public static int c(View view, int i2) {
        if (i2 == 3) {
            return (int) (al.c(view.getContext().getApplicationContext()) * 0.7d);
        }
        return 20;
    }

    public static int d(View view, int i2) {
        if (i2 == 3) {
            return al.d(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    public static int b(View view, int i2, int i3) throws Throwable {
        if (com.bytedance.sdk.openadsdk.utils.i.a()) {
            if (a(view)) {
                if (b(view, i3)) {
                    return !a(view, i2) ? 3 : 0;
                }
                return 6;
            }
            return 1;
        }
        return 4;
    }

    public static boolean a(View view) {
        return view != null && view.isShown();
    }

    public static boolean a(View view, int i2, int i3) {
        try {
            return b(view, i2, i3) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
