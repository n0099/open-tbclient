package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        an anVar;
        an anVar2;
        wVar = this.cHd.cGU;
        anVar = this.cHd.cGS;
        String amO = anVar.amO();
        anVar2 = this.cHd.cGS;
        wVar.bb(amO, anVar2.amS());
    }
}
