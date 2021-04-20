package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.h.c.c;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f28254a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28255b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28256c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile q<com.bytedance.sdk.openadsdk.c.a> f28257d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.m.a f28258e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.h.c.a f28259f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile Context f28260g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.core.h.h f28261h;
    public static final AtomicBoolean i = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static volatile Application f28263a;

        static {
            try {
                Object b2 = b();
                f28263a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.u.f("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application a() {
            return f28263a;
        }

        public static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static Context a() {
        if (f28260g == null) {
            a(null);
        }
        return f28260g;
    }

    public static void b() {
        f28254a = null;
        f28258e = null;
        f28259f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f28254a == null) {
            synchronized (p.class) {
                if (f28254a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28254a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f28254a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(f28260g), f(), l(), b(f28260g));
                    }
                }
            }
        }
        return f28254a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28256c == null) {
            synchronized (p.class) {
                if (f28256c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28256c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        f28256c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return f28256c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28255b == null) {
            synchronized (p.class) {
                if (f28255b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28255b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        f28255b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f28255b;
    }

    public static q<com.bytedance.sdk.openadsdk.c.a> f() {
        if (f28257d == null) {
            synchronized (p.class) {
                if (f28257d == null) {
                    f28257d = new r(f28260g);
                }
            }
        }
        return f28257d;
    }

    public static com.bytedance.sdk.openadsdk.m.a g() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.m.b.c();
        }
        if (f28258e == null) {
            synchronized (com.bytedance.sdk.openadsdk.m.a.class) {
                if (f28258e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28258e = new com.bytedance.sdk.openadsdk.m.c();
                    } else {
                        f28258e = new com.bytedance.sdk.openadsdk.m.b(f28260g, new com.bytedance.sdk.openadsdk.m.g(f28260g));
                    }
                }
            }
        }
        return f28258e;
    }

    public static com.bytedance.sdk.openadsdk.core.h.h h() {
        if (f28261h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.h.class) {
                if (f28261h == null) {
                    f28261h = new com.bytedance.sdk.openadsdk.core.h.h();
                }
            }
        }
        return f28261h;
    }

    public static com.bytedance.sdk.openadsdk.h.c.a i() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.h.c.c.c();
        }
        if (f28259f == null) {
            synchronized (com.bytedance.sdk.openadsdk.h.c.c.class) {
                if (f28259f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28259f = new com.bytedance.sdk.openadsdk.h.c.d();
                    } else {
                        f28259f = new com.bytedance.sdk.openadsdk.h.c.c();
                    }
                }
            }
        }
        return f28259f;
    }

    public static void j() {
        AtomicBoolean atomicBoolean = i;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
        }
    }

    public static boolean k() {
        AtomicBoolean atomicBoolean = i;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }

    public static g.b l() {
        return g.b.a();
    }

    public static synchronized void a(Context context) {
        synchronized (p.class) {
            if (f28260g == null) {
                if (context != null) {
                    f28260g = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        f28260g = a.a();
                        if (f28260g != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static g.a b(final Context context) {
        return new g.a() { // from class: com.bytedance.sdk.openadsdk.core.p.1
            @Override // com.bytedance.sdk.openadsdk.c.g.a
            public boolean a() {
                Context context2 = context;
                if (context2 == null) {
                    context2 = p.a();
                }
                return com.bytedance.sdk.openadsdk.utils.x.a(context2);
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> a(String str, String str2, boolean z) {
        g.b b2;
        com.bytedance.sdk.openadsdk.c.e lVar;
        if (z) {
            lVar = new com.bytedance.sdk.openadsdk.c.n(f28260g);
            b2 = g.b.a();
        } else {
            b2 = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(f28260g);
        }
        g.a b3 = b(f28260g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, b3));
    }
}
