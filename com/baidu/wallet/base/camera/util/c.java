package com.baidu.wallet.base.camera.util;

import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Thread[] f23583a = null;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f23584b;

    public c() {
        this.f23584b = null;
        this.f23584b = new LinkedBlockingQueue<>();
    }

    public static int a(int i) {
        if (i <= 0 || 20 < i) {
            return 4;
        }
        return i;
    }

    public static c a(int i, String str) {
        if (str == null) {
            str = "";
        }
        int a2 = a(i);
        c cVar = new c();
        cVar.f23583a = new Thread[a2];
        for (int i2 = a2 - 1; i2 >= 0; i2 += -1) {
            cVar.f23583a[i2] = new Thread(new d(cVar.f23584b));
            cVar.f23583a[i2].setPriority(5);
            cVar.f23583a[i2].setName(str + " " + a2 + "." + (i2 + 1));
            cVar.f23583a[i2].start();
        }
        return cVar;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            this.f23584b.put(runnable);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        Thread[] threadArr;
        this.f23584b.clear();
        for (Thread thread : this.f23583a) {
            if (thread.isAlive()) {
                this.f23584b.offer(new b());
            }
        }
        for (Thread thread2 : this.f23583a) {
            if (thread2.isAlive()) {
                try {
                    synchronized (this) {
                        wait(2000 / this.f23583a.length);
                    }
                } catch (InterruptedException unused) {
                }
                thread2.interrupt();
            }
        }
    }
}
