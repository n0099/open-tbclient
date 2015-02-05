package com.baidu.tieba.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ com.baidu.tieba.data.e buq;
    final /* synthetic */ e bur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, com.baidu.tieba.data.e eVar2) {
        this.bur = eVar;
        this.buq = eVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        h hVar;
        dVar = this.bur.bup;
        g gVar = new g(dVar);
        gVar.type = 0;
        if (this.buq != null && this.buq.isSuccess()) {
            gVar.azr = true;
            gVar.but = this.buq;
        } else {
            gVar.azr = false;
            gVar.but = this.buq;
        }
        dVar2 = this.bur.bup;
        hVar = dVar2.buk;
        hVar.a(gVar);
    }
}
