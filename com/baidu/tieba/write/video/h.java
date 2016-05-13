package com.baidu.tieba.write.video;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ WriteVideoActivity faD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteVideoActivity writeVideoActivity) {
        this.faD = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        int i;
        eVar = this.faD.fay;
        if (eVar != null) {
            eVar2 = this.faD.fay;
            i = this.faD.faA;
            eVar2.setPercent(i);
        }
    }
}
