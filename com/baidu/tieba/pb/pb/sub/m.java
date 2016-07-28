package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        af afVar;
        aw awVar;
        aw awVar2;
        afVar = this.ejr.ejg;
        awVar = this.ejr.eje;
        String aMa = awVar.aMa();
        awVar2 = this.ejr.eje;
        afVar.bE(aMa, awVar2.aMe());
    }
}
