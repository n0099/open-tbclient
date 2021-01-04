package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static volatile k f6533a;

    /* renamed from: b  reason: collision with root package name */
    private c f6534b = c.a();
    private Map<String, Object> c;
    private b d;

    public static k a() {
        if (f6533a == null) {
            synchronized (k.class) {
                if (f6533a == null) {
                    f6533a = new k();
                }
            }
        }
        return f6533a;
    }

    private k() {
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, boolean z) {
        this.d = b.a(lVar, str, this.c, z);
        com.bytedance.sdk.openadsdk.k.a.a().a((Runnable) new a(100), 0L);
    }

    private void a(b bVar) {
        if (bVar != null) {
            bVar.b();
            if (bVar.a() * this.f6534b.f6539a > this.f6534b.f6540b) {
                c(bVar.a(false));
            } else {
                com.bytedance.sdk.openadsdk.k.a.a().a(new a(100), this.f6534b.f6539a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        if (bVar != null) {
            Context a2 = com.bytedance.sdk.openadsdk.core.p.a();
            if (aj.c(a2, a2.getPackageName())) {
                a(bVar);
            } else {
                c(bVar.a(true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f6536b;

        public a(int i) {
            this.f6536b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6536b == 100 && k.this.d != null) {
                k.this.b(k.this.d);
            }
        }
    }

    private void c(b bVar) {
        if (bVar != null) {
            com.bytedance.sdk.openadsdk.k.a.a().d(bVar, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Serializable, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f6537a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f6538b = new AtomicBoolean(false);
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
            this.f6538b.set(z);
            return this;
        }

        public int a() {
            return this.f6537a.get();
        }

        public void b() {
            this.f6537a.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == null || TextUtils.isEmpty(this.d)) {
                u.a("materialMeta or eventTag is null, pls check");
            } else if (this.f) {
                u.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.f6538b.get());
                d.b(com.bytedance.sdk.openadsdk.core.p.a(), this.c, this.d, this.f6538b.get() ? "lp_dpl_success" : "lp_dpl_failed");
            } else {
                d.i(com.bytedance.sdk.openadsdk.core.p.a(), this.c, this.d, this.f6538b.get() ? "dpl_success" : "dpl_failed", this.e);
                if (this.f6538b != null && this.f6538b.get() && this.c != null) {
                    k.b(this.c, this.d);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        if (lVar != null && !TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.utils.k.a(System.currentTimeMillis());
            JSONObject am = lVar.am();
            if (am != null) {
                com.bytedance.sdk.openadsdk.utils.k.c(am.toString());
                com.bytedance.sdk.openadsdk.utils.k.b(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f6539a = 500;

        /* renamed from: b  reason: collision with root package name */
        public int f6540b = 5000;

        public static c a() {
            return new c();
        }
    }
}
