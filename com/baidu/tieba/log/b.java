package com.baidu.tieba.log;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1913a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1913a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        for (int i = 0; i < 60; i++) {
            atomicBoolean2 = this.f1913a.f1912a;
            if (!atomicBoolean2.get()) {
                break;
            }
            try {
                synchronized (this) {
                    wait(3000L);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a("BdLogger", "write error ", e);
            }
        }
        atomicBoolean = this.f1913a.f1912a;
        if (!atomicBoolean.get()) {
            this.f1913a.b(true);
        }
    }
}
