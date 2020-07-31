package com.bun.miitmdid.utils;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes19.dex */
public class b {
    private static Context a;

    public static Context a() {
        Context context;
        synchronized (b.class) {
            if (a == null) {
                a = b();
            }
            context = a;
        }
        return context;
    }

    public static void a(Context context) {
        synchronized (b.class) {
            a = context;
        }
    }

    public static Context b() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
