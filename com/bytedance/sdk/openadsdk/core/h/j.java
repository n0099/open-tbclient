package com.bytedance.sdk.openadsdk.core.h;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f6893a = new AtomicInteger(1);

    public static boolean a() {
        return f6893a.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i) {
        Throwable th;
        boolean z;
        boolean z2 = true;
        if (i == 1 || i == 2) {
            try {
                if (f6893a.get() == i) {
                    z2 = false;
                } else {
                    try {
                        f6893a.set(i);
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                        th.printStackTrace();
                        z2 = z;
                        if (!z2) {
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
            if (!z2) {
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
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    if (p.g() != null) {
                        p.g().a();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                try {
                    if (p.j() != null) {
                        p.j().b();
                    }
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        }
    }
}
