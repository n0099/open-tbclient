package com.baidu.tieba.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ com.baidu.tieba.data.e bur;
    final /* synthetic */ e bus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, com.baidu.tieba.data.e eVar2) {
        this.bus = eVar;
        this.bur = eVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        h hVar;
        dVar = this.bus.buq;
        g gVar = new g(dVar);
        gVar.type = 0;
        if (this.bur != null && this.bur.isSuccess()) {
            gVar.azu = true;
            gVar.buu = this.bur;
        } else {
            gVar.azu = false;
            gVar.buu = this.bur;
        }
        dVar2 = this.bus.buq;
        hVar = dVar2.bul;
        hVar.a(gVar);
    }
}
