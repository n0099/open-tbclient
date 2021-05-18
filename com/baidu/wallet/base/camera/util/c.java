package com.baidu.wallet.base.camera.util;

import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Thread[] f23239a = null;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f23240b;

    public c() {
        this.f23240b = null;
        this.f23240b = new LinkedBlockingQueue<>();
    }

    public static int a(int i2) {
        if (i2 <= 0 || 20 < i2) {
            return 4;
        }
        return i2;
    }

    public static c a(int i2, String str) {
        if (str == null) {
            str = "";
        }
        int a2 = a(i2);
        c cVar = new c();
        cVar.f23239a = new Thread[a2];
        for (int i3 = a2 - 1; i3 >= 0; i3 += -1) {
            cVar.f23239a[i3] = new Thread(new d(cVar.f23240b));
            cVar.f23239a[i3].setPriority(5);
            cVar.f23239a[i3].setName(str + " " + a2 + "." + (i3 + 1));
            cVar.f23239a[i3].start();
        }
        return cVar;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            this.f23240b.put(runnable);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        Thread[] threadArr;
        this.f23240b.clear();
        for (Thread thread : this.f23239a) {
            if (thread.isAlive()) {
                this.f23240b.offer(new b());
            }
        }
        for (Thread thread2 : this.f23239a) {
            if (thread2.isAlive()) {
                try {
                    synchronized (this) {
                        wait(2000 / this.f23239a.length);
                    }
                } catch (InterruptedException unused) {
                }
                thread2.interrupt();
            }
        }
    }
}
