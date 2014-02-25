package com.baidu.tieba.mainentrance;

import android.content.Context;
/* loaded from: classes.dex */
public class f {
    private static e a = null;

    public static void a(Context context, int i) {
        if (a != null) {
            a.a(context, i);
        }
    }

    public static void a(Context context) {
        if (a != null) {
            a.a(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (a != null) {
            a.a(context, i, z);
        }
    }

    public static void b(Context context, int i) {
        if (a != null) {
            a.b(context, i);
        }
    }

    public static Class a() {
        if (a == null) {
            return null;
        }
        return a.a();
    }

    public static String b() {
        if (a == null) {
            return null;
        }
        return a.b();
    }

    public static void a(e eVar) {
        if (eVar != null) {
            a = eVar;
        }
    }
}
