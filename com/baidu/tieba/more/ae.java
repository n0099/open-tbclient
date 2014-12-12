package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ ad buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.buB = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        ab abVar3;
        com.baidu.adp.base.i iVar;
        abVar = this.buB.buA;
        abVar.mLoadDataMode = 2;
        abVar2 = this.buB.buA;
        abVar2.setErrorString(null);
        abVar3 = this.buB.buA;
        iVar = abVar3.mLoadDataCallBack;
        iVar.c(true);
    }
}
