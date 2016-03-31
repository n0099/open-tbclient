package com.baidu.tieba.write.video;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ WriteVideoActivity eJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteVideoActivity writeVideoActivity) {
        this.eJN = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        int i;
        eVar = this.eJN.eJI;
        if (eVar != null) {
            eVar2 = this.eJN.eJI;
            i = this.eJN.eJK;
            eVar2.ci(i);
        }
    }
}
