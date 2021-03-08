package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.g.c.c;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f4504a;
    private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> b;
    private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> c;
    private static volatile q<com.bytedance.sdk.openadsdk.c.a> d;
    private static volatile com.bytedance.sdk.openadsdk.k.a e;
    private static volatile com.bytedance.sdk.openadsdk.g.c.a f;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context g;
    private static volatile com.bytedance.sdk.openadsdk.core.h.h h;
    private static final AtomicBoolean i = new AtomicBoolean(false);

    public static Context a() {
        if (g == null) {
            a(null);
        }
        return g;
    }

    public static synchronized void a(Context context) {
        synchronized (p.class) {
            if (g == null) {
                if (context != null) {
                    g = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        g = a.a();
                        if (g != null) {
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public static void b() {
        f4504a = null;
        e = null;
        f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f4504a == null) {
            synchronized (p.class) {
                if (f4504a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f4504a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f4504a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(g), f(), l(), b(g));
                    }
                }
            }
        }
        return f4504a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (c == null) {
            synchronized (p.class) {
                if (c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        c = new com.bytedance.sdk.openadsdk.c.m(false);
                    } else {
                        c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return c;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> e() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (b == null) {
            synchronized (p.class) {
                if (b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return b;
    }

    public static q<com.bytedance.sdk.openadsdk.c.a> f() {
        if (d == null) {
            synchronized (p.class) {
                if (d == null) {
                    d = new r(g);
                }
            }
        }
        return d;
    }

    public static com.bytedance.sdk.openadsdk.k.a g() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.k.b.c();
        }
        if (e == null) {
            synchronized (com.bytedance.sdk.openadsdk.k.a.class) {
                if (e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        e = new com.bytedance.sdk.openadsdk.k.c();
                    } else {
                        e = new com.bytedance.sdk.openadsdk.k.b(g, new com.bytedance.sdk.openadsdk.k.g(g));
                    }
                }
            }
        }
        return e;
    }

    private static g.b l() {
        return g.b.a();
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> a(String str, String str2, boolean z) {
        g.b b2;
        com.bytedance.sdk.openadsdk.c.e lVar;
        if (z) {
            lVar = new com.bytedance.sdk.openadsdk.c.n(g);
            b2 = g.b.a();
        } else {
            b2 = g.b.b();
            lVar = new com.bytedance.sdk.openadsdk.c.l(g);
        }
        g.a b3 = b(g);
        return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, b3, new com.bytedance.sdk.openadsdk.c.o(str, str2, lVar, null, b2, b3));
    }

    private static g.a b(final Context context) {
        return new g.a() { // from class: com.bytedance.sdk.openadsdk.core.p.1
            @Override // com.bytedance.sdk.openadsdk.c.g.a
            public boolean a() {
                return com.bytedance.sdk.openadsdk.utils.x.a(context == null ? p.a() : context);
            }
        };
    }

    public static com.bytedance.sdk.openadsdk.core.h.h h() {
        if (h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.h.class) {
                if (h == null) {
                    h = new com.bytedance.sdk.openadsdk.core.h.h();
                }
            }
        }
        return h;
    }

    public static com.bytedance.sdk.openadsdk.g.c.a i() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return com.bytedance.sdk.openadsdk.g.c.c.c();
        }
        if (f == null) {
            synchronized (com.bytedance.sdk.openadsdk.g.c.c.class) {
                if (f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f = new com.bytedance.sdk.openadsdk.g.c.d();
                    } else {
                        f = new com.bytedance.sdk.openadsdk.g.c.c();
                    }
                }
            }
        }
        return f;
    }

    public static void j() {
        if (i != null) {
            i.set(true);
        }
    }

    public static boolean k() {
        if (i != null) {
            return i.get();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        private static volatile Application f4506a;

        @Nullable
        public static Application a() {
            return f4506a;
        }

        static {
            try {
                Object b = b();
                f4506a = (Application) b.getClass().getMethod("getApplication", new Class[0]).invoke(b, new Object[0]);
                com.bytedance.sdk.openadsdk.utils.u.f("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.c("MyApplication", "application get failed", th);
            }
        }

        private static Object b() {
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
}
