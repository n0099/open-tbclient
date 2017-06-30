package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class cf implements Runnable {
    final /* synthetic */ WriteUrlActivity gmD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(WriteUrlActivity writeUrlActivity) {
        this.gmD = writeUrlActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cq cqVar;
        cq cqVar2;
        com.baidu.tieba.write.a.a aVar;
        boolean z;
        cqVar = this.gmD.gmx;
        if (cqVar != null) {
            cqVar2 = this.gmD.gmx;
            aVar = this.gmD.gmA;
            z = this.gmD.isLoading;
            cqVar2.a(aVar, z);
        }
    }
}
