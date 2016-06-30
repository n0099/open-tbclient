package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        af afVar;
        aw awVar;
        aw awVar2;
        afVar = this.dWP.dWE;
        awVar = this.dWP.dWC;
        String aIP = awVar.aIP();
        awVar2 = this.dWP.dWC;
        afVar.bz(aIP, awVar2.aIT());
    }
}
