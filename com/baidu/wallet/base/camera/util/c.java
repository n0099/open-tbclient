package com.baidu.wallet.base.camera.util;

import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Thread[] f23994a = null;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f23995b;

    public c() {
        this.f23995b = null;
        this.f23995b = new LinkedBlockingQueue<>();
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
        cVar.f23994a = new Thread[a2];
        for (int i3 = a2 - 1; i3 >= 0; i3 += -1) {
            cVar.f23994a[i3] = new Thread(new d(cVar.f23995b));
            cVar.f23994a[i3].setPriority(5);
            cVar.f23994a[i3].setName(str + " " + a2 + "." + (i3 + 1));
            cVar.f23994a[i3].start();
        }
        return cVar;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            this.f23995b.put(runnable);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        Thread[] threadArr;
        this.f23995b.clear();
        for (Thread thread : this.f23994a) {
            if (thread.isAlive()) {
                this.f23995b.offer(new b());
            }
        }
        for (Thread thread2 : this.f23994a) {
            if (thread2.isAlive()) {
                try {
                    synchronized (this) {
                        wait(2000 / this.f23994a.length);
                    }
                } catch (InterruptedException unused) {
                }
                thread2.interrupt();
            }
        }
    }
}
