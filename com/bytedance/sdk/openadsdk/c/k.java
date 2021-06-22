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
    public static volatile k f27450a;

    /* renamed from: b  reason: collision with root package name */
    public c f27451b = c.a();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f27452c;

    /* renamed from: d  reason: collision with root package name */
    public b f27453d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f27455b;

        public a(int i2) {
            this.f27455b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27455b != 100 || k.this.f27453d == null) {
                return;
            }
            k kVar = k.this;
            kVar.b(kVar.f27453d);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends com.bytedance.sdk.openadsdk.l.g implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f27456a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f27457b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.d.l f27458c;

        /* renamed from: d  reason: collision with root package name */
        public String f27459d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f27460e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27461f;

        public b() {
            super("EventData");
            this.f27456a = new AtomicInteger(0);
            this.f27457b = new AtomicBoolean(false);
        }

        public static b a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map, boolean z) {
            return new b(lVar, str, map, z);
        }

        public void b() {
            this.f27456a.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            com.bytedance.sdk.openadsdk.core.d.l lVar;
            if (this.f27458c != null && !TextUtils.isEmpty(this.f27459d) && (atomicBoolean = this.f27457b) != null) {
                if (this.f27461f) {
                    u.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.f27457b.get());
                    d.b(com.bytedance.sdk.openadsdk.core.p.a(), this.f27458c, this.f27459d, this.f27457b.get() ? "lp_dpl_success" : "lp_dpl_failed");
                    return;
                }
                d.i(com.bytedance.sdk.openadsdk.core.p.a(), this.f27458c, this.f27459d, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.f27460e);
                AtomicBoolean atomicBoolean2 = this.f27457b;
                if (atomicBoolean2 == null || !atomicBoolean2.get() || (lVar = this.f27458c) == null) {
                    return;
                }
                k.b(lVar, this.f27459d);
                return;
            }
            u.a("materialMeta or eventTag or sResult is null, pls check");
        }

        public b a(boolean z) {
            this.f27457b.set(z);
            return this;
        }

        public int a() {
            return this.f27456a.get();
        }

        public b(com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Map<String, Object> map, boolean z) {
            super("EventData");
            this.f27456a = new AtomicInteger(0);
            this.f27457b = new AtomicBoolean(false);
            this.f27458c = lVar;
            this.f27459d = str;
            this.f27460e = map;
            this.f27461f = z;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f27462a = 500;

        /* renamed from: b  reason: collision with root package name */
        public int f27463b = 5000;

        /* renamed from: c  reason: collision with root package name */
        public int f27464c = 1000;

        /* renamed from: d  reason: collision with root package name */
        public int f27465d = 300;

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
        if (f27450a == null) {
            synchronized (k.class) {
                if (f27450a == null) {
                    f27450a = new k();
                }
            }
        }
        return f27450a;
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
        this.f27453d = b.a(lVar, str, this.f27452c, z);
        com.bytedance.sdk.openadsdk.l.e.d().schedule(new a(100), 0L, TimeUnit.MILLISECONDS);
    }

    private void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.b();
        int a2 = bVar.a();
        c cVar = this.f27451b;
        if (a2 * cVar.f27462a > cVar.f27463b) {
            c(bVar.a(false));
        } else {
            com.bytedance.sdk.openadsdk.l.e.d().schedule(new a(100), this.f27451b.f27462a, TimeUnit.MILLISECONDS);
        }
    }
}
