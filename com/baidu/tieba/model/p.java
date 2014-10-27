package com.baidu.tieba.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    private final /* synthetic */ com.baidu.tieba.data.o bov;
    final /* synthetic */ o bow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.data.o oVar2) {
        this.bow = oVar;
        this.bov = oVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        n nVar2;
        r rVar;
        nVar = this.bow.bou;
        q qVar = new q(nVar);
        qVar.type = 0;
        if (this.bov != null && this.bov.isSuccess()) {
            qVar.avc = true;
            qVar.boy = this.bov;
        } else {
            qVar.avc = false;
            qVar.boy = this.bov;
        }
        nVar2 = this.bow.bou;
        rVar = nVar2.bot;
        rVar.a(qVar);
    }
}
