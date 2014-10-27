package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ ae bqZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.bqZ = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ac acVar;
        ac acVar2;
        ac acVar3;
        com.baidu.adp.base.h hVar;
        acVar = this.bqZ.bqY;
        acVar.mLoadDataMode = 2;
        acVar2 = this.bqZ.bqY;
        acVar2.setErrorString(null);
        acVar3 = this.bqZ.bqY;
        hVar = acVar3.mLoadDataCallBack;
        hVar.a(true);
    }
}
