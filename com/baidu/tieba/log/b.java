package com.baidu.tieba.log;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        for (int i = 0; i < 60; i++) {
            atomicBoolean2 = this.a.a;
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
        atomicBoolean = this.a.a;
        if (!atomicBoolean.get()) {
            this.a.b(true);
        }
    }
}
