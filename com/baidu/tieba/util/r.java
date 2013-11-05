package com.baidu.tieba.util;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f2458a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.f2458a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicBoolean atomicBoolean;
        String str;
        String str2;
        try {
            o oVar = this.f2458a;
            str = o.d;
            oVar.a(str, 0L);
            o oVar2 = this.f2458a;
            str2 = o.e;
            oVar2.a(str2, 0L);
        } finally {
            atomicBoolean = this.f2458a.b;
            atomicBoolean.set(false);
        }
    }
}
