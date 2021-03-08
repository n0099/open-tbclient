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
/* loaded from: classes6.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f4048a;
    private final Set<Request<?>> b;
    private final PriorityBlockingQueue<Request<?>> c;
    private final PriorityBlockingQueue<Request<?>> d;
    private final List<b> j;
    private final List<a> k;
    private final com.bytedance.sdk.adnet.e.b pxN;
    private final com.bytedance.sdk.adnet.e.c pxO;
    private final com.bytedance.sdk.adnet.e.d pxP;
    private final j[] pxQ;
    private f pxR;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Request<?> request, int i);
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public interface b<T> {
        void b(Request<T> request);
    }

    public n(com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.c cVar, int i, com.bytedance.sdk.adnet.e.d dVar) {
        this.f4048a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.pxN = bVar;
        this.pxO = cVar;
        this.pxQ = new j[i];
        this.pxP = dVar;
    }

    public n(com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.c cVar, int i) {
        this(bVar, cVar, i, new i(new Handler(Looper.getMainLooper())));
    }

    public n(com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.c cVar) {
        this(bVar, cVar, 4);
    }

    public void a() {
        b();
        this.pxR = new f(this.c, this.d, this.pxN, this.pxP);
        this.pxR.setName("tt_pangle_thread_CacheDispatcher");
        this.pxR.start();
        for (int i = 0; i < this.pxQ.length; i++) {
            j jVar = new j(this.d, this.pxO, this.pxN, this.pxP);
            jVar.setName("tt_pangle_thread_NetworkDispatcher" + i);
            this.pxQ[i] = jVar;
            jVar.start();
        }
    }

    public void b() {
        j[] jVarArr;
        if (this.pxR != null) {
            this.pxR.a();
        }
        for (j jVar : this.pxQ) {
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    public int c() {
        return this.f4048a.incrementAndGet();
    }

    public <T> Request<T> j(Request<T> request) {
        f(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.b) {
            this.b.add(request);
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

    public <T> void f(Request<T> request) {
        if (request != null && !TextUtils.isEmpty(request.getUrl())) {
            String url = request.getUrl();
            if (com.bytedance.sdk.adnet.a.eqS() != null) {
                String a2 = com.bytedance.sdk.adnet.a.eqS().a(url);
                if (!TextUtils.isEmpty(a2)) {
                    request.setUrl(a2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void k(Request<T> request) {
        synchronized (this.b) {
            this.b.remove(request);
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
