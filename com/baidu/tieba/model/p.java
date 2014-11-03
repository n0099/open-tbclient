package com.baidu.tieba.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    private final /* synthetic */ com.baidu.tieba.data.o boJ;
    final /* synthetic */ o boK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.data.o oVar2) {
        this.boK = oVar;
        this.boJ = oVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        n nVar2;
        r rVar;
        nVar = this.boK.boI;
        q qVar = new q(nVar);
        qVar.type = 0;
        if (this.boJ != null && this.boJ.isSuccess()) {
            qVar.avl = true;
            qVar.boM = this.boJ;
        } else {
            qVar.avl = false;
            qVar.boM = this.boJ;
        }
        nVar2 = this.boK.boI;
        rVar = nVar2.boH;
        rVar.a(qVar);
    }
}
