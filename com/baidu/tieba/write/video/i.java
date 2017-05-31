package com.baidu.tieba.write.video;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ WriteVideoActivity fXr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.fXr = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        int i;
        eVar = this.fXr.cgF;
        if (eVar != null) {
            eVar2 = this.fXr.cgF;
            i = this.fXr.fXm;
            eVar2.cg(i);
        }
    }
}
