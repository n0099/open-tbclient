package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.a = bjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.a.j;
        if (z) {
            this.a.f();
        }
    }
}
