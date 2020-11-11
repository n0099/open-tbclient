package com.bun.miitmdid.utils;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes11.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3998a;

    public static Context a() {
        Context context;
        synchronized (b.class) {
            if (f3998a == null) {
                f3998a = b();
            }
            context = f3998a;
        }
        return context;
    }

    public static void a(Context context) {
        synchronized (b.class) {
            f3998a = context;
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
