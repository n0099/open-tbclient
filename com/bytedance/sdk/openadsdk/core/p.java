package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.h.b.c;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f6659a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f6660b;
    private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> c;
    private static volatile q<com.bytedance.sdk.openadsdk.c.a> d;
    private static volatile com.bytedance.sdk.openadsdk.l.a e;
    private static volatile com.bytedance.sdk.openadsdk.h.b.a f;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context g;
    private static volatile com.bytedance.sdk.openadsdk.core.h.l h;
    private static volatile com.bytedance.sdk.openadsdk.core.h.k i;
    private static final AtomicBoolean j = new AtomicBoolean(false);

    public static Context a() {
        if (g == null) {
            a(null);
        }
        return g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (com.bytedance.sdk.openadsdk.core.p.g != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context) {
        synchronized (p.class) {
            if (g == null) {
                if (a.a() != null) {
                    try {
                        g = a.a();
                    } catch (Throwable th) {
                    }
                }
                if (context != null) {
                    g = context.getApplicationContext();
                }
            }
        }
    }

    public static void b() {
        f6659a = null;
        e = null;
        f = null;
    }

    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!com.bytedance.sdk.openadsdk.core.h.j.a()) {
            return com.bytedance.sdk.openadsdk.c.b.c();
        }
        if (f6659a == null) {
            synchronized (p.class) {
                if (f6659a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f6659a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        f6659a = new com.bytedance.sdk.openadsdk.c.b<>(new com.bytedance.sdk.openadsdk.c.f(g), f(), m(), b(g));
                    }
                }
            }
        }
        return f6659a;
    }

    public static com.bytedance.sdk.openadsdk.c.b<c.a> d() {
        if (!com.bytedance.sdk.openadsdk.core.h.j.a()) {
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
        if (!com.bytedance.sdk.openadsdk.core.h.j.a()) {
            return com.bytedance.sdk.openadsdk.c.b.d();
        }
        if (f6660b == null) {
            synchronized (p.class) {
                if (f6660b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f6660b = new com.bytedance.sdk.openadsdk.c.m(true);
                    } else {
                        f6660b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return f6660b;
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

    public static com.bytedance.sdk.openadsdk.l.a g() {
        if (!com.bytedance.sdk.openadsdk.core.h.j.a()) {
            return com.bytedance.sdk.openadsdk.l.b.c();
        }
        if (e == null) {
            synchronized (com.bytedance.sdk.openadsdk.l.a.class) {
                if (e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        e = new com.bytedance.sdk.openadsdk.l.c();
                    } else {
                        e = new com.bytedance.sdk.openadsdk.l.b(g, new com.bytedance.sdk.openadsdk.l.g(g));
                    }
                }
            }
        }
        return e;
    }

    private static g.b m() {
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

    public static com.bytedance.sdk.openadsdk.core.h.l h() {
        if (h == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.l.class) {
                if (h == null) {
                    h = new com.bytedance.sdk.openadsdk.core.h.l();
                }
            }
        }
        return h;
    }

    public static com.bytedance.sdk.openadsdk.core.h.k i() {
        if (i == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.h.l.class) {
                if (i == null) {
                    i = new com.bytedance.sdk.openadsdk.core.h.k();
                    i.b();
                }
            }
        }
        return i;
    }

    public static com.bytedance.sdk.openadsdk.h.b.a j() {
        if (!com.bytedance.sdk.openadsdk.core.h.j.a()) {
            return com.bytedance.sdk.openadsdk.h.b.c.c();
        }
        if (f == null) {
            synchronized (com.bytedance.sdk.openadsdk.h.b.c.class) {
                if (f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f = new com.bytedance.sdk.openadsdk.h.b.d();
                    } else {
                        f = new com.bytedance.sdk.openadsdk.h.b.c();
                    }
                }
            }
        }
        return f;
    }

    public static void k() {
        if (j != null) {
            j.set(true);
        }
    }

    public static boolean l() {
        if (j != null) {
            return j.get();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        private static volatile Application f6662a;

        @Nullable
        public static Application a() {
            return f6662a;
        }

        static {
            try {
                Object b2 = b();
                f6662a = (Application) b2.getClass().getMethod("getApplication", new Class[0]).invoke(b2, new Object[0]);
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
