package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.aa;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class q {
    private Runnable c;
    private ExecutorService d;

    /* renamed from: a  reason: collision with root package name */
    private int f5971a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f5972b = 5;
    private final Deque<aa.a> ptX = new ArrayDeque();
    private final Deque<aa.a> ptY = new ArrayDeque();
    private final Deque<aa> ptZ = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.bm("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    private void c() {
        if (this.ptY.size() < this.f5971a && !this.ptX.isEmpty()) {
            Iterator<aa.a> it = this.ptX.iterator();
            while (it.hasNext()) {
                aa.a next = it.next();
                if (a(next) < this.f5972b) {
                    it.remove();
                    this.ptY.add(next);
                    a().execute(next);
                }
                if (this.ptY.size() >= this.f5971a) {
                    return;
                }
            }
        }
    }

    private int a(aa.a aVar) {
        int i = 0;
        Iterator<aa.a> it = this.ptY.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().a().equals(aVar.a()) ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(aa aaVar) {
        this.ptZ.add(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(aa.a aVar) {
        a(this.ptY, aVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(aa aaVar) {
        a(this.ptZ, aaVar, false);
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int b2;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                c();
            }
            b2 = b();
            runnable = this.c;
        }
        if (b2 == 0 && runnable != null) {
            runnable.run();
        }
    }

    public synchronized int b() {
        return this.ptY.size() + this.ptZ.size();
    }
}
