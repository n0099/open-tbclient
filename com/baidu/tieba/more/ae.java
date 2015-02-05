package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ ad bvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bvW = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        ab abVar3;
        com.baidu.adp.base.i iVar;
        abVar = this.bvW.bvV;
        abVar.mLoadDataMode = 2;
        abVar2 = this.bvW.bvV;
        abVar2.setErrorString(null);
        abVar3 = this.bvW.bvV;
        iVar = abVar3.mLoadDataCallBack;
        iVar.c(true);
    }
}
