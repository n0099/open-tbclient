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
/* loaded from: classes6.dex */
public class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4037a = q.f4050a;
    private final BlockingQueue<Request<?>> b;
    private final BlockingQueue<Request<?>> c;
    private final com.bytedance.sdk.adnet.e.b pxD;
    private final com.bytedance.sdk.adnet.e.d pxE;
    private volatile boolean f = false;
    private final a pxF = new a(this);

    public f(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.bytedance.sdk.adnet.e.b bVar, com.bytedance.sdk.adnet.e.d dVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.pxD = bVar;
        this.pxE = dVar;
    }

    public void a() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f4037a) {
            q.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.pxD.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException e) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                q.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        b(this.b.take());
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
            b.a Zj = this.pxD.Zj(request.getCacheKey());
            if (Zj == null) {
                request.addMarker("cache-miss");
                if (!this.pxF.d(request)) {
                    this.c.put(request);
                }
            } else if (Zj.a()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(Zj);
                if (!this.pxF.d(request)) {
                    this.c.put(request);
                }
            } else {
                request.addMarker("cache-hit");
                o<?> a2 = request.a(new k(Zj.b, Zj.h));
                request.addMarker("cache-hit-parsed");
                if (Zj.b()) {
                    request.addMarker("cache-hit-refresh-needed");
                    request.setCacheEntry(Zj);
                    a2.d = true;
                    if (this.pxF.d(request)) {
                        this.pxE.a(request, a2);
                    } else {
                        this.pxE.a(request, a2, new Runnable() { // from class: com.bytedance.sdk.adnet.core.f.1
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
                    this.pxE.a(request, a2);
                }
            }
        } catch (Throwable th) {
            try {
                q.a(th, "CacheDispatcher Unhandled Throwable %s", th.toString());
                this.pxE.a(request, new VAdError(th));
            } finally {
                request.a(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Request.a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, List<Request<?>>> f4038a = new HashMap();
        private final f pxG;

        a(f fVar) {
            this.pxG = fVar;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public void a(Request<?> request, o<?> oVar) {
            List<Request<?>> remove;
            if (oVar.pxS == null || oVar.pxS.a()) {
                b(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.f4038a.remove(cacheKey);
            }
            if (remove != null) {
                if (q.f4050a) {
                    q.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                for (Request<?> request2 : remove) {
                    this.pxG.pxE.a(request2, oVar);
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public synchronized void b(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.f4038a.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (q.f4050a) {
                    q.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.f4038a.put(cacheKey, remove);
                remove2.a(this);
                try {
                    this.pxG.c.put(remove2);
                } catch (InterruptedException e) {
                    q.c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.pxG.a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean d(Request<?> request) {
            boolean z = false;
            synchronized (this) {
                String cacheKey = request.getCacheKey();
                if (this.f4038a.containsKey(cacheKey)) {
                    List<Request<?>> list = this.f4038a.get(cacheKey);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    request.addMarker("waiting-for-response");
                    list.add(request);
                    this.f4038a.put(cacheKey, list);
                    if (q.f4050a) {
                        q.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                    }
                    z = true;
                } else {
                    this.f4038a.put(cacheKey, null);
                    request.a(this);
                    if (q.f4050a) {
                        q.b("new request, sending to network %s", cacheKey);
                    }
                }
            }
            return z;
        }
    }
}
