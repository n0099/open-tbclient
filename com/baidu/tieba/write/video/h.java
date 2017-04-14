package com.baidu.tieba.write.video;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ WriteVideoActivity fOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteVideoActivity writeVideoActivity) {
        this.fOZ = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        int i;
        eVar = this.fOZ.cao;
        if (eVar != null) {
            eVar2 = this.fOZ.cao;
            i = this.fOZ.fOW;
            eVar2.ch(i);
        }
    }
}
