package com.baidu.ufosdk.f;

import android.annotation.SuppressLint;
import android.util.Log;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f23341a = "UFO";

    public static int a(String str) {
        if (com.baidu.ufosdk.b.o <= 1) {
            return Log.d(f23341a, str);
        }
        return 0;
    }

    public static int a(String str, Throwable th) {
        if (com.baidu.ufosdk.b.o <= 4) {
            return Log.w(f23341a, str, th);
        }
        return 0;
    }

    public static int b(String str) {
        if (com.baidu.ufosdk.b.o <= 2) {
            return Log.i(f23341a, str);
        }
        return 0;
    }

    public static int c(String str) {
        if (com.baidu.ufosdk.b.o <= 3) {
            return Log.w(f23341a, str);
        }
        return 0;
    }

    public static int d(String str) {
        if (com.baidu.ufosdk.b.o <= 4) {
            return Log.e(f23341a, str);
        }
        return 0;
    }
}
