package com.baidu.tieba.setting.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ y caH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.caH = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        com.baidu.adp.base.i iVar;
        wVar = this.caH.caG;
        wVar.mLoadDataMode = 2;
        wVar2 = this.caH.caG;
        wVar2.setErrorString(null);
        wVar3 = this.caH.caG;
        iVar = wVar3.mLoadDataCallBack;
        iVar.c(true);
    }
}
