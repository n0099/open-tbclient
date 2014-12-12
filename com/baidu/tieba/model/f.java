package com.baidu.tieba.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ com.baidu.tieba.data.e bsT;
    final /* synthetic */ e bsU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, com.baidu.tieba.data.e eVar2) {
        this.bsU = eVar;
        this.bsT = eVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        h hVar;
        dVar = this.bsU.bsS;
        g gVar = new g(dVar);
        gVar.type = 0;
        if (this.bsT != null && this.bsT.isSuccess()) {
            gVar.ayu = true;
            gVar.bsW = this.bsT;
        } else {
            gVar.ayu = false;
            gVar.bsW = this.bsT;
        }
        dVar2 = this.bsU.bsS;
        hVar = dVar2.bsN;
        hVar.a(gVar);
    }
}
