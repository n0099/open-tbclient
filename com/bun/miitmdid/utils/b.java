package com.bun.miitmdid.utils;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f27014a;

    public static Context a() {
        Context context;
        synchronized (b.class) {
            if (f27014a == null) {
                f27014a = b();
            }
            context = f27014a;
        }
        return context;
    }

    public static void a(Context context) {
        synchronized (b.class) {
            f27014a = context;
        }
    }

    public static Context b() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
