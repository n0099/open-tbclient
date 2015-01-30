package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ ad bvX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bvX = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        ab abVar3;
        com.baidu.adp.base.i iVar;
        abVar = this.bvX.bvW;
        abVar.mLoadDataMode = 2;
        abVar2 = this.bvX.bvW;
        abVar2.setErrorString(null);
        abVar3 = this.bvX.bvW;
        iVar = abVar3.mLoadDataCallBack;
        iVar.c(true);
    }
}
