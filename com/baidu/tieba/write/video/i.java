package com.baidu.tieba.write.video;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ WriteVideoActivity gir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteVideoActivity writeVideoActivity) {
        this.gir = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        int i;
        eVar = this.gir.coV;
        if (eVar != null) {
            eVar2 = this.gir.coV;
            i = this.gir.gim;
            eVar2.cg(i);
        }
    }
}
