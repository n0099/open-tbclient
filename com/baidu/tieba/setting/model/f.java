package com.baidu.tieba.setting.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e cvZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cvZ = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c cVar3;
        com.baidu.adp.base.g gVar;
        cVar = this.cvZ.cvY;
        cVar.mLoadDataMode = 2;
        cVar2 = this.cvZ.cvY;
        cVar2.setErrorString(null);
        cVar3 = this.cvZ.cvY;
        gVar = cVar3.mLoadDataCallBack;
        gVar.d(true);
    }
}
