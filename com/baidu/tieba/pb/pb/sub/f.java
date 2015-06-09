package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar;
        ak akVar;
        ak akVar2;
        sVar = this.bPx.bPr;
        akVar = this.bPx.bPo;
        String adJ = akVar.adJ();
        akVar2 = this.bPx.bPo;
        sVar.aV(adJ, akVar2.adM());
    }
}
