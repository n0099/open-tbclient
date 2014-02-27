package com.baidu.tieba.mainentrance;

import android.content.Context;
/* loaded from: classes.dex */
public final class d {
    private static c a = null;

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
            a.a(context, i, false);
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

    public static void a(c cVar) {
        if (cVar != null) {
            a = cVar;
        }
    }
}
