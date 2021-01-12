package com.bun.miitmdid.utils;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5765a;

    public static Context a() {
        Context context;
        synchronized (b.class) {
            if (f5765a == null) {
                f5765a = b();
            }
            context = f5765a;
        }
        return context;
    }

    public static void a(Context context) {
        synchronized (b.class) {
            f5765a = context;
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
