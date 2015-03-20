package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ boolean bMt;
    final /* synthetic */ l bOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, boolean z) {
        this.bOf = lVar;
        this.bMt = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOf.mListView.setEnabled(this.bMt);
    }
}
