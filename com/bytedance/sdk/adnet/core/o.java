package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f6043a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Request<?>> f6044b;
    private final PriorityBlockingQueue<Request<?>> c;
    private final PriorityBlockingQueue<Request<?>> d;
    private final List<b> j;
    private final List<a> k;
    private final com.bytedance.sdk.adnet.e.b pkT;
    private final com.bytedance.sdk.adnet.e.c pkU;
    private final com.bytedance.sdk.adnet.e.d pkV;
    private final k[] pkW;
    private f pkX;

    /* loaded from: classes4.dex */
    public interface a {
        void a(Request<?> request, int i);
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface b<T> {
        void b(Request<T> request);
    }

    public o(com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.c cVar, int i, com.bytedance.sdk.adnet.e.d dVar) {
        this.f6043a = new AtomicInteger();
        this.f6044b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.pkT = bVar;
        this.pkU = cVar;
        this.pkW = new k[i];
        this.pkV = dVar;
    }

    public o(com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.c cVar, int i) {
        this(bVar, cVar, i, new i(new Handler(Looper.getMainLooper())));
    }

    public o(com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.c cVar) {
        this(bVar, cVar, 4);
    }

    public void a() {
        b();
        this.pkX = new f(this.c, this.d, this.pkT, this.pkV);
        this.pkX.start();
        for (int i = 0; i < this.pkW.length; i++) {
            k kVar = new k(this.d, this.pkU, this.pkT, this.pkV);
            this.pkW[i] = kVar;
            kVar.start();
        }
    }

    public void b() {
        k[] kVarArr;
        if (this.pkX != null) {
            this.pkX.a();
        }
        for (k kVar : this.pkW) {
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    public int c() {
        return this.f6043a.incrementAndGet();
    }

    public <T> Request<T> j(Request<T> request) {
        g(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.f6044b) {
            this.f6044b.add(request);
        }
        request.setSequence(c());
        request.addMarker("add-to-queue");
        a(request, 0);
        if (!request.shouldCache()) {
            this.d.add(request);
        } else {
            this.c.add(request);
        }
        return request;
    }

    public <T> void g(Request<T> request) {
        if (request != null && !TextUtils.isEmpty(request.getUrl())) {
            String url = request.getUrl();
            if (com.bytedance.sdk.adnet.a.eol() != null) {
                String a2 = com.bytedance.sdk.adnet.a.eol().a(url);
                if (!TextUtils.isEmpty(a2)) {
                    request.setUrl(a2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void k(Request<T> request) {
        synchronized (this.f6044b) {
            this.f6044b.remove(request);
        }
        synchronized (this.j) {
            for (b bVar : this.j) {
                bVar.b(request);
            }
        }
        a(request, 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Request<?> request, int i) {
        synchronized (this.k) {
            for (a aVar : this.k) {
                aVar.a(request, i);
            }
        }
    }
}
