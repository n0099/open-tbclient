package com.baidu.tieba.kn.pk;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1295a;
    private final /* synthetic */ y b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, y yVar, boolean z) {
        this.f1295a = tVar;
        this.b = yVar;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinkedList linkedList;
        long j;
        long j2;
        linkedList = this.f1295a.r;
        linkedList.remove(this);
        this.f1295a.a(this.b, this.c, true);
        if (this.c) {
            t tVar = this.f1295a;
            j2 = tVar.p;
            tVar.p = j2 + this.b.b;
        } else {
            t tVar2 = this.f1295a;
            j = tVar2.q;
            tVar2.q = j + this.b.b;
        }
        this.f1295a.d();
    }
}
