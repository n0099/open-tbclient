package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ l eCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.eCy = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        t tVar2;
        this.eCy.aPg();
        tVar = this.eCy.eCo;
        tVar.aPj();
        tVar2 = this.eCy.eCo;
        tVar2.setVisibility(8);
    }
}
