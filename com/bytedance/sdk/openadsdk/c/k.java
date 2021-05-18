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
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f27336a;

    /* renamed from: b  reason: collision with root package name */
    public c f27337b = c.a();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f27338c;

    /* renamed from: d  reason: collision with root package name */
    public b f27339d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f27341b;

        public a(int i2) {
            this.f27341b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27341b != 100 || k.this.f27339d == null) {
                return;
            }
            k kVar = k.this;
            kVar.b(kVar.f27339d);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends com.bytedance.sdk.openadsdk.l.g implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f27342a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f27343b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.d.l f27344c;

        /* renamed from: d  reason: collision with root package name */
        public String f27345d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f27346e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27347f;

        public b() {
            super("EventData");
            this.f27342a = new AtomicInteger(0);
            this.f27343b = new AtomicBoolean(false);
        }

        public static b a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map, boolean z) {
            return new b(lVar, str, map, z);
        }

        public void b() {
            this.f27342a.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            com.bytedance.sdk.openadsdk.core.d.l lVar;
            if (this.f27344c != null && !TextUtils.isEmpty(this.f27345d) && (atomicBoolean = this.f27343b) != null) {
                if (this.f27347f) {
                    u.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.f27343b.get());
                    d.b(com.bytedance.sdk.openadsdk.core.p.a(), this.f27344c, this.f27345d, this.f27343b.get() ? "lp_dpl_success" : "lp_dpl_failed");
                    return;
                }
                d.i(com.bytedance.sdk.openadsdk.core.p.a(), this.f27344c, this.f27345d, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.f27346e);
                AtomicBoolean atomicBoolean2 = this.f27343b;
                if (atomicBoolean2 == null || !atomicBoolean2.get() || (lVar = this.f27344c) == null) {
                    return;
                }
                k.b(lVar, this.f27345d);
                return;
            }
            u.a("materialMeta or eventTag or sResult is null, pls check");
        }

        public b a(boolean z) {
            this.f27343b.set(z);
            return this;
        }

        public int a() {
            return this.f27342a.get();
        }

        public b(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map, boolean z) {
            super("EventData");
            this.f27342a = new AtomicInteger(0);
            this.f27343b = new AtomicBoolean(false);
            this.f27344c = lVar;
            this.f27345d = str;
            this.f27346e = map;
            this.f27347f = z;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f27348a = 500;

        /* renamed from: b  reason: collision with root package name */
        public int f27349b = 5000;

        /* renamed from: c  reason: collision with root package name */
        public int f27350c = 1000;

        /* renamed from: d  reason: collision with root package name */
        public int f27351d = 300;

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
        if (f27336a == null) {
            synchronized (k.class) {
                if (f27336a == null) {
                    f27336a = new k();
                }
            }
        }
        return f27336a;
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
        this.f27339d = b.a(lVar, str, this.f27338c, z);
        com.bytedance.sdk.openadsdk.l.e.d().schedule(new a(100), 0L, TimeUnit.MILLISECONDS);
    }

    private void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.b();
        int a2 = bVar.a();
        c cVar = this.f27337b;
        if (a2 * cVar.f27348a > cVar.f27349b) {
            c(bVar.a(false));
        } else {
            com.bytedance.sdk.openadsdk.l.e.d().schedule(new a(100), this.f27337b.f27348a, TimeUnit.MILLISECONDS);
        }
    }
}
