package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        ak akVar;
        ak akVar2;
        tVar = this.cfY.cfR;
        akVar = this.cfY.cfP;
        String afv = akVar.afv();
        akVar2 = this.cfY.cfP;
        tVar.aV(afv, akVar2.afy());
    }
}
