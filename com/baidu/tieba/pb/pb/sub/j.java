package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        ao aoVar;
        ao aoVar2;
        wVar = this.cLc.cKT;
        aoVar = this.cLc.cKR;
        String anZ = aoVar.anZ();
        aoVar2 = this.cLc.cKR;
        wVar.aW(anZ, aoVar2.aod());
    }
}
