package com.baidu.tieba.log;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        try {
            try {
                this.b.f(this.a);
                atomicBoolean3 = this.b.a;
                atomicBoolean3.set(false);
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a("BdLogger", "write error ", e);
                atomicBoolean = this.b.a;
                atomicBoolean.set(false);
            }
        } catch (Throwable th) {
            atomicBoolean2 = this.b.a;
            atomicBoolean2.set(false);
            throw th;
        }
    }
}
