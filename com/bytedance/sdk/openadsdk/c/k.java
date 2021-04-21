package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f27265a;

    /* renamed from: b  reason: collision with root package name */
    public c f27266b = c.a();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f27267c;

    /* renamed from: d  reason: collision with root package name */
    public b f27268d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f27270b;

        public a(int i) {
            this.f27270b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27270b != 100 || k.this.f27268d == null) {
                return;
            }
            k kVar = k.this;
            kVar.b(kVar.f27268d);
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends com.bytedance.sdk.openadsdk.l.g implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f27271a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f27272b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.d.l f27273c;

        /* renamed from: d  reason: collision with root package name */
        public String f27274d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f27275e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27276f;

        public b() {
            super("EventData");
            this.f27271a = new AtomicInteger(0);
            this.f27272b = new AtomicBoolean(false);
        }

        public static b a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map, boolean z) {
            return new b(lVar, str, map, z);
        }

        public void b() {
            this.f27271a.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            com.bytedance.sdk.openadsdk.core.d.l lVar;
            if (this.f27273c != null && !TextUtils.isEmpty(this.f27274d) && (atomicBoolean = this.f27272b) != null) {
                if (this.f27276f) {
                    u.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.f27272b.get());
                    d.b(com.bytedance.sdk.openadsdk.core.p.a(), this.f27273c, this.f27274d, this.f27272b.get() ? "lp_dpl_success" : "lp_dpl_failed");
                    return;
                }
                d.i(com.bytedance.sdk.openadsdk.core.p.a(), this.f27273c, this.f27274d, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.f27275e);
                AtomicBoolean atomicBoolean2 = this.f27272b;
                if (atomicBoolean2 == null || !atomicBoolean2.get() || (lVar = this.f27273c) == null) {
                    return;
                }
                k.b(lVar, this.f27274d);
                return;
            }
            u.a("materialMeta or eventTag or sResult is null, pls check");
        }

        public b a(boolean z) {
            this.f27272b.set(z);
            return this;
        }

        public int a() {
            return this.f27271a.get();
        }

        public b(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map, boolean z) {
            super("EventData");
            this.f27271a = new AtomicInteger(0);
            this.f27272b = new AtomicBoolean(false);
            this.f27273c = lVar;
            this.f27274d = str;
            this.f27275e = map;
            this.f27276f = z;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f27277a = 500;

        /* renamed from: b  reason: collision with root package name */
        public int f27278b = 5000;

        /* renamed from: c  reason: collision with root package name */
        public int f27279c = 1000;

        /* renamed from: d  reason: collision with root package name */
        public int f27280d = 300;

        public static c a() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        if (ak.a()) {
            a(bVar);
        } else {
            c(bVar.a(true));
        }
    }

    private void c(b bVar) {
        if (bVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.e.a(bVar, 5);
    }

    public static k a() {
        if (f27265a == null) {
            synchronized (k.class) {
                if (f27265a == null) {
                    f27265a = new k();
                }
            }
        }
        return f27265a;
    }

    public static void b(com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        if (lVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.k.a(System.currentTimeMillis());
        JSONObject aL = lVar.aL();
        if (aL == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.k.d(aL.toString());
        com.bytedance.sdk.openadsdk.utils.k.c(str);
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, boolean z) {
        this.f27268d = b.a(lVar, str, this.f27267c, z);
        com.bytedance.sdk.openadsdk.l.e.d().schedule(new a(100), 0L, TimeUnit.MILLISECONDS);
    }

    private void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.b();
        int a2 = bVar.a();
        c cVar = this.f27266b;
        if (a2 * cVar.f27277a > cVar.f27278b) {
            c(bVar.a(false));
        } else {
            com.bytedance.sdk.openadsdk.l.e.d().schedule(new a(100), this.f27266b.f27277a, TimeUnit.MILLISECONDS);
        }
    }
}
