package com.bytedance.embedapplog;

import android.util.Log;
/* loaded from: classes4.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6084a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f6085b = false;

    public static void a(String str, Throwable th) {
        if (f6085b) {
            Log.d("TeaLog", str, th);
        }
    }

    public static void b(String str, Throwable th) {
        Log.w("TeaLog", str, th);
    }

    public static void c(String str, Throwable th) {
        Log.e("TeaLog", str, th);
    }

    public static void d(String str, Throwable th) {
        Log.i("TeaLog", str, th);
    }

    public static void a(Throwable th) {
        Log.e("TeaLog", "U SHALL NOT PASS!", th);
    }
}
