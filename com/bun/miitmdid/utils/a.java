package com.bun.miitmdid.utils;

import android.util.Log;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f26930a;

    /* renamed from: b  reason: collision with root package name */
    public int f26931b = -1;

    public static a a() {
        if (f26930a == null) {
            synchronized (a.class) {
                if (f26930a == null) {
                    f26930a = new a();
                }
            }
        }
        return f26930a;
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
        a().f26931b = z ? 1 : 0;
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
        return a().f26931b == 1;
    }
}
