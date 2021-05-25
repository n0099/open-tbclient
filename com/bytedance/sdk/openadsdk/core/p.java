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
    public static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f28303a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28304b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28305c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile q<com.bytedance.sdk.openadsdk.c.a> f28306d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.m.a f28307e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.h.c.a f28308f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile Context f28309g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.core.h.h f28310h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicBoolean f28311i = new AtomicBoolean(false);

    /* loaded from: classes6.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static volatile Application f28313a;

        static {
            try {
                Object b2 = b();
                f28313a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.u.f("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application a() {
            return f28313a;
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
        if (f28309g == null) {
            a(null);
        }
        return f28309g;
    }

    public static void b() {
        f28303a = null;
        f28307e = null;
        f28308f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f28303a == null) {
            synchronized (p.class) {
                if (f28303a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28303a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f28303a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(f28309g), f(), l(), b(f28309g));
                    }
                }
            }
        }
        return f28303a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28305c == null) {
            synchronized (p.class) {
                if (f28305c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28305c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        f28305c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return f28305c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28304b == null) {
            synchronized (p.class) {
                if (f28304b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28304b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        f28304b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f28304b;
    }

    public static q<com.bytedance.sdk.openadsdk.c.a> f() {
        if (f28306d == null) {
            synchronized (p.class) {
                if (f28306d == null) {
                    f28306d = new r(f28309g);
                }
            }
        }
        return f28306d;
    }

    public static com.bytedance.sdk.openadsdk.m.a g() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.m.b.c();
        }
        if (f28307e == null) {
            synchronized (com.bytedance.sdk.openadsdk.m.a.class) {
                if (f28307e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28307e = new com.bytedance.sdk.openadsdk.m.c();
                    } else {
                        f28307e = new com.bytedance.sdk.openadsdk.m.b(f28309g, new com.bytedance.sdk.openadsdk.m.g(f28309g));
                    }
                }
            }
        }
        return f28307e;
    }

    public static com.bytedance.sdk.openadsdk.core.h.h h() {
        if (f28310h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.h.class) {
                if (f28310h == null) {
                    f28310h = new com.bytedance.sdk.openadsdk.core.h.h();
                }
            }
        }
        return f28310h;
    }

    public static com.bytedance.sdk.openadsdk.h.c.a i() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.h.c.c.c();
        }
        if (f28308f == null) {
            synchronized (com.bytedance.sdk.openadsdk.h.c.c.class) {
                if (f28308f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28308f = new com.bytedance.sdk.openadsdk.h.c.d();
                    } else {
                        f28308f = new com.bytedance.sdk.openadsdk.h.c.c();
                    }
                }
            }
        }
        return f28308f;
    }

    public static void j() {
        AtomicBoolean atomicBoolean = f28311i;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
        }
    }

    public static boolean k() {
        AtomicBoolean atomicBoolean = f28311i;
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
            if (f28309g == null) {
                if (context != null) {
                    f28309g = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        f28309g = a.a();
                        if (f28309g != null) {
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
            lVar = new com.bytedance.sdk.openadsdk.c.n(f28309g);
            b2 = g.b.a();
        } else {
            b2 = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(f28309g);
        }
        g.a b3 = b(f28309g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, b3));
    }
}
