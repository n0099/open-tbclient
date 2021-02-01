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
    private final Deque<aa.a> ptx = new ArrayDeque();
    private final Deque<aa.a> pty = new ArrayDeque();
    private final Deque<aa> ptz = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.bm("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    private void c() {
        if (this.pty.size() < this.f5971a && !this.ptx.isEmpty()) {
            Iterator<aa.a> it = this.ptx.iterator();
            while (it.hasNext()) {
                aa.a next = it.next();
                if (a(next) < this.f5972b) {
                    it.remove();
                    this.pty.add(next);
                    a().execute(next);
                }
                if (this.pty.size() >= this.f5971a) {
                    return;
                }
            }
        }
    }

    private int a(aa.a aVar) {
        int i = 0;
        Iterator<aa.a> it = this.pty.iterator();
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
        this.ptz.add(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(aa.a aVar) {
        a(this.pty, aVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(aa aaVar) {
        a(this.ptz, aaVar, false);
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
        return this.pty.size() + this.ptz.size();
    }
}
