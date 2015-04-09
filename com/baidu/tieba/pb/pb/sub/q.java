package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ boolean bMJ;
    final /* synthetic */ l bOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, boolean z) {
        this.bOv = lVar;
        this.bMJ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOv.mListView.setEnabled(this.bMJ);
    }
}
