package com.bun.miitmdid.utils;

import android.util.Log;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f26831a;

    /* renamed from: b  reason: collision with root package name */
    public int f26832b = -1;

    public static a a() {
        if (f26831a == null) {
            synchronized (a.class) {
                if (f26831a == null) {
                    f26831a = new a();
                }
            }
        }
        return f26831a;
    }

    public static void a(String str, String str2) {
        if (b()) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (b()) {
            Log.d(str, str2, th);
        }
    }

    public static void a(boolean z) {
        a().f26832b = z ? 1 : 0;
    }

    public static void b(String str, String str2) {
        if (b()) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (b()) {
            Log.e(str, str2, th);
        }
    }

    public static boolean b() {
        return a().f26832b == 1;
    }
}
