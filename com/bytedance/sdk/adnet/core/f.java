package com.bytedance.sdk.adnet.core;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.e.b;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f6022a = r.f6046a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<Request<?>> f6023b;
    private final BlockingQueue<Request<?>> c;
    private final com.bytedance.sdk.adnet.e.b pkI;
    private final com.bytedance.sdk.adnet.e.d pkJ;
    private volatile boolean f = false;
    private final a pkK = new a(this);

    public f(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.d dVar) {
        this.f6023b = blockingQueue;
        this.c = blockingQueue2;
        this.pkI = bVar;
        this.pkJ = dVar;
    }

    public void a() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f6022a) {
            r.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.pkI.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException e) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                r.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        b(this.f6023b.take());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [219=6] */
    @VisibleForTesting
    void b(final Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.a(1);
        try {
            if (request.isCanceled()) {
                request.a("cache-discard-canceled");
                return;
            }
            b.a XO = this.pkI.XO(request.getCacheKey());
            if (XO == null) {
                request.addMarker("cache-miss");
                if (!this.pkK.d(request)) {
                    this.c.put(request);
                }
            } else if (XO.a()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(XO);
                if (!this.pkK.d(request)) {
                    this.c.put(request);
                }
            } else {
                request.addMarker("cache-hit");
                p<?> a2 = request.a(new l(XO.f6062b, XO.h));
                request.addMarker("cache-hit-parsed");
                if (XO.b()) {
                    request.addMarker("cache-hit-refresh-needed");
                    request.setCacheEntry(XO);
                    a2.d = true;
                    if (this.pkK.d(request)) {
                        this.pkJ.a(request, a2);
                    } else {
                        this.pkJ.a(request, a2, new Runnable() { // from class: com.bytedance.sdk.adnet.core.f.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    f.this.c.put(request);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        });
                    }
                } else {
                    this.pkJ.a(request, a2);
                }
            }
        } catch (Throwable th) {
            try {
                r.a(th, "CacheDispatcher Unhandled Throwable %s", th.toString());
                this.pkJ.a(request, new VAdError(th));
            } finally {
                request.a(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Request.a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, List<Request<?>>> f6024a = new HashMap();
        private final f pkL;

        a(f fVar) {
            this.pkL = fVar;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public void a(Request<?> request, p<?> pVar) {
            List<Request<?>> remove;
            if (pVar.pkY == null || pVar.pkY.a()) {
                b(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.f6024a.remove(cacheKey);
            }
            if (remove != null) {
                if (r.f6046a) {
                    r.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                for (Request<?> request2 : remove) {
                    this.pkL.pkJ.a(request2, pVar);
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public synchronized void b(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.f6024a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (r.f6046a) {
                    r.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.f6024a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.pkL.c.put(remove2);
                } catch (InterruptedException e) {
                    r.c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.pkL.a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean d(Request<?> request) {
            boolean z = false;
            synchronized (this) {
                String cacheKey = request.getCacheKey();
                if (this.f6024a.containsKey(cacheKey)) {
                    List<Request<?>> list = this.f6024a.get(cacheKey);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    request.addMarker("waiting-for-response");
                    list.add(request);
                    this.f6024a.put(cacheKey, list);
                    if (r.f6046a) {
                        r.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                    }
                    z = true;
                } else {
                    this.f6024a.put(cacheKey, null);
                    request.a(this);
                    if (r.f6046a) {
                        r.b("new request, sending to network %s", cacheKey);
                    }
                }
            }
            return z;
        }
    }
}
