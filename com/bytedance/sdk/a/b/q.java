package com.bytedance.sdk.a.b;

import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.sdk.a.b.aa;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class q {
    private Runnable c;
    private ExecutorService d;

    /* renamed from: a  reason: collision with root package name */
    private int f6268a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f6269b = 5;
    private final Deque<aa.a> pnJ = new ArrayDeque();
    private final Deque<aa.a> pnK = new ArrayDeque();
    private final Deque<aa> pnL = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.bm("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    private void c() {
        if (this.pnK.size() < this.f6268a && !this.pnJ.isEmpty()) {
            Iterator<aa.a> it = this.pnJ.iterator();
            while (it.hasNext()) {
                aa.a next = it.next();
                if (a(next) < this.f6269b) {
                    it.remove();
                    this.pnK.add(next);
                    a().execute(next);
                }
                if (this.pnK.size() >= this.f6268a) {
                    return;
                }
            }
        }
    }

    private int a(aa.a aVar) {
        int i = 0;
        Iterator<aa.a> it = this.pnK.iterator();
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
        this.pnL.add(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(aa.a aVar) {
        a(this.pnK, aVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(aa aaVar) {
        a(this.pnL, aaVar, false);
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
        return this.pnK.size() + this.pnL.size();
    }
}
