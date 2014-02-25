package com.baidu.tieba.log;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ a a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        try {
            try {
                this.a.f(this.b);
                atomicBoolean3 = this.a.a;
                atomicBoolean3.set(false);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.a("BdLogger", "write error ", e);
                atomicBoolean = this.a.a;
                atomicBoolean.set(false);
            }
        } catch (Throwable th) {
            atomicBoolean2 = this.a.a;
            atomicBoolean2.set(false);
            throw th;
        }
    }
}
