package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static volatile k f4205a;
    private c b = c.a();
    private Map<String, Object> c;
    private b d;

    public static k a() {
        if (f4205a == null) {
            synchronized (k.class) {
                if (f4205a == null) {
                    f4205a = new k();
                }
            }
        }
        return f4205a;
    }

    private k() {
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, boolean z) {
        this.d = b.a(lVar, str, this.c, z);
        com.bytedance.sdk.openadsdk.j.e.c().schedule(new a(100), 0L, TimeUnit.MILLISECONDS);
    }

    private void a(b bVar) {
        if (bVar != null) {
            bVar.b();
            if (bVar.a() * this.b.f4208a > this.b.b) {
                c(bVar.a(false));
            } else {
                com.bytedance.sdk.openadsdk.j.e.c().schedule(new a(100), this.b.f4208a, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        if (bVar != null) {
            if (aj.a()) {
                a(bVar);
            } else {
                c(bVar.a(true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private int b;

        public a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b == 100 && k.this.d != null) {
                k.this.b(k.this.d);
            }
        }
    }

    private void c(b bVar) {
        if (bVar != null) {
            com.bytedance.sdk.openadsdk.j.e.a(bVar, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements Serializable, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4207a = new AtomicInteger(0);
        public final AtomicBoolean b = new AtomicBoolean(false);
        public com.bytedance.sdk.openadsdk.core.d.l c;
        public String d;
        public Map<String, Object> e;
        public boolean f;

        public static b a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map, boolean z) {
            return new b(lVar, str, map, z);
        }

        public b() {
        }

        public b(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map, boolean z) {
            this.c = lVar;
            this.d = str;
            this.e = map;
            this.f = z;
        }

        public b a(boolean z) {
            this.b.set(z);
            return this;
        }

        public int a() {
            return this.f4207a.get();
        }

        public void b() {
            this.f4207a.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == null || TextUtils.isEmpty(this.d) || this.b == null) {
                u.a("materialMeta or eventTag or sResult is null, pls check");
            } else if (this.f) {
                u.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.b.get());
                d.b(com.bytedance.sdk.openadsdk.core.p.a(), this.c, this.d, this.b.get() ? "lp_dpl_success" : "lp_dpl_failed");
            } else {
                d.i(com.bytedance.sdk.openadsdk.core.p.a(), this.c, this.d, this.b.get() ? "dpl_success" : "dpl_failed", this.e);
                if (this.b != null && this.b.get() && this.c != null) {
                    k.b(this.c, this.d);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        if (lVar != null && !TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.utils.k.a(System.currentTimeMillis());
            JSONObject aE = lVar.aE();
            if (aE != null) {
                com.bytedance.sdk.openadsdk.utils.k.d(aE.toString());
                com.bytedance.sdk.openadsdk.utils.k.c(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f4208a = 500;
        public int b = 5000;
        public int c = 1000;
        public int d = 300;

        public static c a() {
            return new c();
        }
    }
}
