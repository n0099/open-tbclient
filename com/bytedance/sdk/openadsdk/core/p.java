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
    public static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f28262a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28263b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28264c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile q<com.bytedance.sdk.openadsdk.c.a> f28265d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.m.a f28266e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.h.c.a f28267f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile Context f28268g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.core.h.h f28269h;
    public static final AtomicBoolean i = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static volatile Application f28271a;

        static {
            try {
                Object b2 = b();
                f28271a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.u.f("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application a() {
            return f28271a;
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
        if (f28268g == null) {
            a(null);
        }
        return f28268g;
    }

    public static void b() {
        f28262a = null;
        f28266e = null;
        f28267f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f28262a == null) {
            synchronized (p.class) {
                if (f28262a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28262a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f28262a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(f28268g), f(), l(), b(f28268g));
                    }
                }
            }
        }
        return f28262a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28264c == null) {
            synchronized (p.class) {
                if (f28264c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28264c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        f28264c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return f28264c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28263b == null) {
            synchronized (p.class) {
                if (f28263b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28263b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        f28263b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f28263b;
    }

    public static q<com.bytedance.sdk.openadsdk.c.a> f() {
        if (f28265d == null) {
            synchronized (p.class) {
                if (f28265d == null) {
                    f28265d = new r(f28268g);
                }
            }
        }
        return f28265d;
    }

    public static com.bytedance.sdk.openadsdk.m.a g() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.m.b.c();
        }
        if (f28266e == null) {
            synchronized (com.bytedance.sdk.openadsdk.m.a.class) {
                if (f28266e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28266e = new com.bytedance.sdk.openadsdk.m.c();
                    } else {
                        f28266e = new com.bytedance.sdk.openadsdk.m.b(f28268g, new com.bytedance.sdk.openadsdk.m.g(f28268g));
                    }
                }
            }
        }
        return f28266e;
    }

    public static com.bytedance.sdk.openadsdk.core.h.h h() {
        if (f28269h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.h.class) {
                if (f28269h == null) {
                    f28269h = new com.bytedance.sdk.openadsdk.core.h.h();
                }
            }
        }
        return f28269h;
    }

    public static com.bytedance.sdk.openadsdk.h.c.a i() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.h.c.c.c();
        }
        if (f28267f == null) {
            synchronized (com.bytedance.sdk.openadsdk.h.c.c.class) {
                if (f28267f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28267f = new com.bytedance.sdk.openadsdk.h.c.d();
                    } else {
                        f28267f = new com.bytedance.sdk.openadsdk.h.c.c();
                    }
                }
            }
        }
        return f28267f;
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
            if (f28268g == null) {
                if (context != null) {
                    f28268g = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        f28268g = a.a();
                        if (f28268g != null) {
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
            lVar = new com.bytedance.sdk.openadsdk.c.n(f28268g);
            b2 = g.b.a();
        } else {
            b2 = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(f28268g);
        }
        g.a b3 = b(f28268g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, b3));
    }
}
