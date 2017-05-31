package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ch implements Runnable {
    final /* synthetic */ WriteUrlActivity gbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(WriteUrlActivity writeUrlActivity) {
        this.gbF = writeUrlActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cs csVar;
        cs csVar2;
        com.baidu.tieba.write.a.a aVar;
        boolean z;
        csVar = this.gbF.gbz;
        if (csVar != null) {
            csVar2 = this.gbF.gbz;
            aVar = this.gbF.gbC;
            z = this.gbF.isLoading;
            csVar2.a(aVar, z);
        }
    }
}
