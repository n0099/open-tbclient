package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        ao aoVar;
        ao aoVar2;
        wVar = this.cTK.cTB;
        aoVar = this.cTK.cTz;
        String asE = aoVar.asE();
        aoVar2 = this.cTK.cTz;
        wVar.bd(asE, aoVar2.asI());
    }
}
