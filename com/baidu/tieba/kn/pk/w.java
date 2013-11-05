package com.baidu.tieba.kn.pk;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1790a;
    final /* synthetic */ boolean b;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, y yVar, boolean z) {
        this.c = tVar;
        this.f1790a = yVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinkedList linkedList;
        linkedList = this.c.r;
        linkedList.remove(this);
        this.c.a(this.f1790a, this.b, true);
        if (this.b) {
            t.a(this.c, this.f1790a.b);
        } else {
            t.b(this.c, this.f1790a.b);
        }
        this.c.d();
    }
}
