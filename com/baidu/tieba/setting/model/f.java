package com.baidu.tieba.setting.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e dsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dsP = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        c cVar2;
        c cVar3;
        com.baidu.adp.base.g gVar;
        cVar = this.dsP.dsO;
        cVar.mLoadDataMode = 2;
        cVar2 = this.dsP.dsO;
        cVar2.setErrorString(null);
        cVar3 = this.dsP.dsO;
        gVar = cVar3.mLoadDataCallBack;
        gVar.d(true);
    }
}
