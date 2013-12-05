package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bj f2334a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.f2334a = bjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bx bxVar;
        if (!this.f2334a.c.p()) {
            bxVar = this.f2334a.an;
            bxVar.a(this.f2334a.n);
        }
    }
}
