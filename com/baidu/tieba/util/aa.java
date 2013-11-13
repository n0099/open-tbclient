package com.baidu.tieba.util;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2475a;
    final /* synthetic */ y b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, String str) {
        this.b = yVar;
        this.f2475a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        try {
            try {
                this.b.c(this.f2475a);
                atomicBoolean = this.b.f2520a;
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.a("DebugLogger", "write error ", e);
                atomicBoolean = this.b.f2520a;
            }
            atomicBoolean.set(false);
        } catch (Throwable th) {
            atomicBoolean2 = this.b.f2520a;
            atomicBoolean2.set(false);
            throw th;
        }
    }
}
