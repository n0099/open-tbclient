package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.h.c.c;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f28374a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28375b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28376c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile q<com.bytedance.sdk.openadsdk.c.a> f28377d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.m.a f28378e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.h.c.a f28379f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile Context f28380g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.core.h.h f28381h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicBoolean f28382i = new AtomicBoolean(false);

    /* loaded from: classes6.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static volatile Application f28384a;

        static {
            try {
                Object b2 = b();
                f28384a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.u.f("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application a() {
            return f28384a;
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
        if (f28380g == null) {
            a(null);
        }
        return f28380g;
    }

    public static void b() {
        f28374a = null;
        f28378e = null;
        f28379f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f28374a == null) {
            synchronized (p.class) {
                if (f28374a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28374a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f28374a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(f28380g), f(), l(), b(f28380g));
                    }
                }
            }
        }
        return f28374a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28376c == null) {
            synchronized (p.class) {
                if (f28376c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28376c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        f28376c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return f28376c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28375b == null) {
            synchronized (p.class) {
                if (f28375b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28375b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        f28375b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f28375b;
    }

    public static q<com.bytedance.sdk.openadsdk.c.a> f() {
        if (f28377d == null) {
            synchronized (p.class) {
                if (f28377d == null) {
                    f28377d = new r(f28380g);
                }
            }
        }
        return f28377d;
    }

    public static com.bytedance.sdk.openadsdk.m.a g() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.m.b.c();
        }
        if (f28378e == null) {
            synchronized (com.bytedance.sdk.openadsdk.m.a.class) {
                if (f28378e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28378e = new com.bytedance.sdk.openadsdk.m.c();
                    } else {
                        f28378e = new com.bytedance.sdk.openadsdk.m.b(f28380g, new com.bytedance.sdk.openadsdk.m.g(f28380g));
                    }
                }
            }
        }
        return f28378e;
    }

    public static com.bytedance.sdk.openadsdk.core.h.h h() {
        if (f28381h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.h.class) {
                if (f28381h == null) {
                    f28381h = new com.bytedance.sdk.openadsdk.core.h.h();
                }
            }
        }
        return f28381h;
    }

    public static com.bytedance.sdk.openadsdk.h.c.a i() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.h.c.c.c();
        }
        if (f28379f == null) {
            synchronized (com.bytedance.sdk.openadsdk.h.c.c.class) {
                if (f28379f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28379f = new com.bytedance.sdk.openadsdk.h.c.d();
                    } else {
                        f28379f = new com.bytedance.sdk.openadsdk.h.c.c();
                    }
                }
            }
        }
        return f28379f;
    }

    public static void j() {
        AtomicBoolean atomicBoolean = f28382i;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
        }
    }

    public static boolean k() {
        AtomicBoolean atomicBoolean = f28382i;
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
            if (f28380g == null) {
                if (context != null) {
                    f28380g = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        f28380g = a.a();
                        if (f28380g != null) {
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
            lVar = new com.bytedance.sdk.openadsdk.c.n(f28380g);
            b2 = g.b.a();
        } else {
            b2 = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(f28380g);
        }
        g.a b3 = b(f28380g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, b3));
    }
}
