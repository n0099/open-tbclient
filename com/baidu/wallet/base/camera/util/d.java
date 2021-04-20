package com.baidu.wallet.base.camera.util;

import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<Runnable> f23271a;

    public d(LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        this.f23271a = linkedBlockingQueue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            try {
                this.f23271a.take().run();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
