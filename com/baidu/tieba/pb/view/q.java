package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ l eLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.eLV = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        t tVar2;
        this.eLV.aTf();
        tVar = this.eLV.eLL;
        tVar.aTi();
        tVar2 = this.eLV.eLL;
        tVar2.setVisibility(8);
    }
}
