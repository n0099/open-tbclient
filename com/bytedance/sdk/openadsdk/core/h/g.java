package com.bytedance.sdk.openadsdk.core.h;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f28115a = new AtomicInteger(1);

    public static boolean a() {
        return f28115a.get() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i) {
        boolean z = true;
        if (i == 1 || i == 2) {
            try {
                if (f28115a.get() != i) {
                    try {
                        f28115a.set(i);
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        if (z) {
                        }
                    }
                } else {
                    z = false;
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
            if (z) {
                return;
            }
            Log.e("SdkSwitch", "switch status changed: " + a());
            if (a()) {
                p.b();
                return;
            }
            try {
                if (p.c() != null) {
                    p.c().b();
                }
                if (p.e() != null) {
                    p.e().b();
                }
                if (p.d() != null) {
                    p.d().b();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                if (p.g() != null) {
                    p.g().a();
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            try {
                if (p.i() != null) {
                    p.i().b();
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
