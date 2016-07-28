package com.baidu.tieba.write.video;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ WriteVideoActivity fSg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteVideoActivity writeVideoActivity) {
        this.fSg = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        int i;
        eVar = this.fSg.fSb;
        if (eVar != null) {
            eVar2 = this.fSg.fSb;
            i = this.fSg.fSd;
            eVar2.setPercent(i);
        }
    }
}
