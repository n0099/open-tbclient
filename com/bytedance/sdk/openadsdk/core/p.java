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
    public static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f28488a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28489b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f28490c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile q<com.bytedance.sdk.openadsdk.c.a> f28491d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.m.a f28492e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.h.c.a f28493f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile Context f28494g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.core.h.h f28495h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicBoolean f28496i = new AtomicBoolean(false);

    /* loaded from: classes6.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static volatile Application f28498a;

        static {
            try {
                Object b2 = b();
                f28498a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.u.f("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application a() {
            return f28498a;
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
        if (f28494g == null) {
            a(null);
        }
        return f28494g;
    }

    public static void b() {
        f28488a = null;
        f28492e = null;
        f28493f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f28488a == null) {
            synchronized (p.class) {
                if (f28488a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28488a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f28488a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(f28494g), f(), l(), b(f28494g));
                    }
                }
            }
        }
        return f28488a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28490c == null) {
            synchronized (p.class) {
                if (f28490c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28490c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        f28490c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return f28490c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f28489b == null) {
            synchronized (p.class) {
                if (f28489b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28489b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        f28489b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f28489b;
    }

    public static q<com.bytedance.sdk.openadsdk.c.a> f() {
        if (f28491d == null) {
            synchronized (p.class) {
                if (f28491d == null) {
                    f28491d = new r(f28494g);
                }
            }
        }
        return f28491d;
    }

    public static com.bytedance.sdk.openadsdk.m.a g() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.m.b.c();
        }
        if (f28492e == null) {
            synchronized (com.bytedance.sdk.openadsdk.m.a.class) {
                if (f28492e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28492e = new com.bytedance.sdk.openadsdk.m.c();
                    } else {
                        f28492e = new com.bytedance.sdk.openadsdk.m.b(f28494g, new com.bytedance.sdk.openadsdk.m.g(f28494g));
                    }
                }
            }
        }
        return f28492e;
    }

    public static com.bytedance.sdk.openadsdk.core.h.h h() {
        if (f28495h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.h.class) {
                if (f28495h == null) {
                    f28495h = new com.bytedance.sdk.openadsdk.core.h.h();
                }
            }
        }
        return f28495h;
    }

    public static com.bytedance.sdk.openadsdk.h.c.a i() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.h.c.c.c();
        }
        if (f28493f == null) {
            synchronized (com.bytedance.sdk.openadsdk.h.c.c.class) {
                if (f28493f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f28493f = new com.bytedance.sdk.openadsdk.h.c.d();
                    } else {
                        f28493f = new com.bytedance.sdk.openadsdk.h.c.c();
                    }
                }
            }
        }
        return f28493f;
    }

    public static void j() {
        AtomicBoolean atomicBoolean = f28496i;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
        }
    }

    public static boolean k() {
        AtomicBoolean atomicBoolean = f28496i;
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
            if (f28494g == null) {
                if (context != null) {
                    f28494g = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        f28494g = a.a();
                        if (f28494g != null) {
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
            lVar = new com.bytedance.sdk.openadsdk.c.n(f28494g);
            b2 = g.b.a();
        } else {
            b2 = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(f28494g);
        }
        g.a b3 = b(f28494g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, b3));
    }
}
