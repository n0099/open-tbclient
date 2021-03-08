package com.bytedance.sdk.a.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.bytedance.sdk.a.b.a.b.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class m {
    static final /* synthetic */ boolean c;
    private static final Executor d;
    boolean b;
    private final int e;
    private final long f;
    private final Runnable g;
    private final Deque<com.bytedance.sdk.a.b.a.b.c> pvV;
    final com.bytedance.sdk.a.b.a.b.d pvW;

    static {
        c = !m.class.desiredAssertionStatus();
        d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.bm("OkHttp ConnectionPool", true));
    }

    public m() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public m(int i, long j, TimeUnit timeUnit) {
        this.g = new Runnable() { // from class: com.bytedance.sdk.a.b.m.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long a2 = m.this.a(System.nanoTime());
                    if (a2 == -1) {
                        return;
                    }
                    if (a2 > 0) {
                        long j2 = a2 / TimeUtils.NANOS_PER_MS;
                        long j3 = a2 - (j2 * TimeUtils.NANOS_PER_MS);
                        synchronized (m.this) {
                            try {
                                m.this.wait(j2, (int) j3);
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            }
        };
        this.pvV = new ArrayDeque();
        this.pvW = new com.bytedance.sdk.a.b.a.b.d();
        this.e = i;
        this.f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.a.b.a.b.c a(a aVar, com.bytedance.sdk.a.b.a.b.g gVar, d dVar) {
        if (c || Thread.holdsLock(this)) {
            for (com.bytedance.sdk.a.b.a.b.c cVar : this.pvV) {
                if (cVar.a(aVar, dVar)) {
                    gVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket a(a aVar, com.bytedance.sdk.a.b.a.b.g gVar) {
        if (c || Thread.holdsLock(this)) {
            for (com.bytedance.sdk.a.b.a.b.c cVar : this.pvV) {
                if (cVar.a(aVar, null) && cVar.d() && cVar != gVar.epu()) {
                    return gVar.b(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.sdk.a.b.a.b.c cVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.b) {
            this.b = true;
            d.execute(this.g);
        }
        this.pvV.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(com.bytedance.sdk.a.b.a.b.c cVar) {
        if (c || Thread.holdsLock(this)) {
            if (cVar.f3951a || this.e == 0) {
                this.pvV.remove(cVar);
                return true;
            }
            notifyAll();
            return false;
        }
        throw new AssertionError();
    }

    long a(long j) {
        com.bytedance.sdk.a.b.a.b.c cVar = null;
        long j2 = Long.MIN_VALUE;
        synchronized (this) {
            int i = 0;
            int i2 = 0;
            for (com.bytedance.sdk.a.b.a.b.c cVar2 : this.pvV) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.e;
                    if (j3 <= j2) {
                        j3 = j2;
                        cVar2 = cVar;
                    }
                    j2 = j3;
                    cVar = cVar2;
                }
            }
            if (j2 >= this.f || i > this.e) {
                this.pvV.remove(cVar);
                com.bytedance.sdk.a.b.a.c.a(cVar.epm());
                return 0L;
            } else if (i > 0) {
                return this.f - j2;
            } else if (i2 > 0) {
                return this.f;
            } else {
                this.b = false;
                return -1L;
            }
        }
    }

    private int a(com.bytedance.sdk.a.b.a.b.c cVar, long j) {
        List<Reference<com.bytedance.sdk.a.b.a.b.g>> list = cVar.d;
        int i = 0;
        while (i < list.size()) {
            Reference<com.bytedance.sdk.a.b.a.b.g> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.bytedance.sdk.a.b.a.g.e.epO().a("A connection to " + cVar.epl().eqa().eoY() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f3955a);
                list.remove(i);
                cVar.f3951a = true;
                if (list.isEmpty()) {
                    cVar.e = j - this.f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
