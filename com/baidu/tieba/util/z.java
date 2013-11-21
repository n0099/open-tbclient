package com.baidu.tieba.util;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f2504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.f2504a = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        for (int i = 0; i < 60; i++) {
            atomicBoolean2 = this.f2504a.f2503a;
            if (!atomicBoolean2.get()) {
                break;
            }
            try {
                synchronized (this) {
                    wait(3000L);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.a("DebugLogger", "write error ", e);
            }
        }
        atomicBoolean = this.f2504a.f2503a;
        if (!atomicBoolean.get()) {
            this.f2504a.b(true);
        }
    }
}
