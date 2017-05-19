package com.baidu.tieba.write.video;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ WriteVideoActivity fPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.fPv = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        int i;
        eVar = this.fPv.cat;
        if (eVar != null) {
            eVar2 = this.fPv.cat;
            i = this.fPv.fPq;
            eVar2.cf(i);
        }
    }
}
