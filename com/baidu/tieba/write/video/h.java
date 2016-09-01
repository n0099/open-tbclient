package com.baidu.tieba.write.video;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ WriteVideoActivity gcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteVideoActivity writeVideoActivity) {
        this.gcl = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        int i;
        eVar = this.gcl.gcg;
        if (eVar != null) {
            eVar2 = this.gcl.gcg;
            i = this.gcl.gci;
            eVar2.setPercent(i);
        }
    }
}
