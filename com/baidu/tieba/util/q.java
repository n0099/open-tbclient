package com.baidu.tieba.util;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2457a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, String str) {
        this.b = oVar;
        this.f2457a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        try {
            try {
                this.b.c(this.f2457a);
                atomicBoolean = this.b.f2455a;
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.a("DebugLogger", "write error ", e);
                atomicBoolean = this.b.f2455a;
            }
            atomicBoolean.set(false);
        } catch (Throwable th) {
            atomicBoolean2 = this.b.f2455a;
            atomicBoolean2.set(false);
            throw th;
        }
    }
}
