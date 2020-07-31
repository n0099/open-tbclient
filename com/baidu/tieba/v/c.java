package com.baidu.tieba.v;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class c {
    public static int Gk(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        return i;
    }

    public static void a(int i, WindowManager.LayoutParams layoutParams, Activity activity) {
        if (layoutParams != null && activity != null && activity.getWindow() != null) {
            try {
                Field declaredField = layoutParams.getClass().getDeclaredField("layoutInDisplayCutoutMode");
                if (declaredField != null) {
                    declaredField.set(layoutParams, Integer.valueOf(i));
                    activity.getWindow().setAttributes(layoutParams);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(int i, WindowManager.LayoutParams layoutParams, Window window) {
        if (layoutParams != null && window != null) {
            try {
                Field declaredField = layoutParams.getClass().getDeclaredField("layoutInDisplayCutoutMode");
                if (declaredField != null) {
                    declaredField.set(layoutParams, Integer.valueOf(i));
                    window.setAttributes(layoutParams);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
    }
}
