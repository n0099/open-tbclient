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
    public static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f29129a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f29130b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f29131c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile q<com.bytedance.sdk.openadsdk.c.a> f29132d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.m.a f29133e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.h.c.a f29134f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile Context f29135g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.core.h.h f29136h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicBoolean f29137i = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static volatile Application f29139a;

        static {
            try {
                Object b2 = b();
                f29139a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.u.f("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application a() {
            return f29139a;
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
        if (f29135g == null) {
            a(null);
        }
        return f29135g;
    }

    public static void b() {
        f29129a = null;
        f29133e = null;
        f29134f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f29129a == null) {
            synchronized (p.class) {
                if (f29129a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f29129a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f29129a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(f29135g), f(), l(), b(f29135g));
                    }
                }
            }
        }
        return f29129a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f29131c == null) {
            synchronized (p.class) {
                if (f29131c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f29131c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        f29131c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return f29131c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f29130b == null) {
            synchronized (p.class) {
                if (f29130b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f29130b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        f29130b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f29130b;
    }

    public static q<com.bytedance.sdk.openadsdk.c.a> f() {
        if (f29132d == null) {
            synchronized (p.class) {
                if (f29132d == null) {
                    f29132d = new r(f29135g);
                }
            }
        }
        return f29132d;
    }

    public static com.bytedance.sdk.openadsdk.m.a g() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.m.b.c();
        }
        if (f29133e == null) {
            synchronized (com.bytedance.sdk.openadsdk.m.a.class) {
                if (f29133e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f29133e = new com.bytedance.sdk.openadsdk.m.c();
                    } else {
                        f29133e = new com.bytedance.sdk.openadsdk.m.b(f29135g, new com.bytedance.sdk.openadsdk.m.g(f29135g));
                    }
                }
            }
        }
        return f29133e;
    }

    public static com.bytedance.sdk.openadsdk.core.h.h h() {
        if (f29136h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.h.class) {
                if (f29136h == null) {
                    f29136h = new com.bytedance.sdk.openadsdk.core.h.h();
                }
            }
        }
        return f29136h;
    }

    public static com.bytedance.sdk.openadsdk.h.c.a i() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.h.c.c.c();
        }
        if (f29134f == null) {
            synchronized (com.bytedance.sdk.openadsdk.h.c.c.class) {
                if (f29134f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f29134f = new com.bytedance.sdk.openadsdk.h.c.d();
                    } else {
                        f29134f = new com.bytedance.sdk.openadsdk.h.c.c();
                    }
                }
            }
        }
        return f29134f;
    }

    public static void j() {
        AtomicBoolean atomicBoolean = f29137i;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
        }
    }

    public static boolean k() {
        AtomicBoolean atomicBoolean = f29137i;
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
            if (f29135g == null) {
                if (context != null) {
                    f29135g = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        f29135g = a.a();
                        if (f29135g != null) {
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
            lVar = new com.bytedance.sdk.openadsdk.c.n(f29135g);
            b2 = g.b.a();
        } else {
            b2 = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(f29135g);
        }
        g.a b3 = b(f29135g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, b3));
    }
}
