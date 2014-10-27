package com.baidu.tieba.pb.sub;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ l bAL;
    private final /* synthetic */ String bAM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, String str) {
        this.bAL = lVar;
        this.bAM = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bAL.hc(this.bAM);
    }
}
