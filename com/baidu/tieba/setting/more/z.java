package com.baidu.tieba.setting.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ y cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.cfw = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        w wVar3;
        com.baidu.adp.base.i iVar;
        wVar = this.cfw.cfv;
        wVar.mLoadDataMode = 2;
        wVar2 = this.cfw.cfv;
        wVar2.setErrorString(null);
        wVar3 = this.cfw.cfv;
        iVar = wVar3.mLoadDataCallBack;
        iVar.c(true);
    }
}
