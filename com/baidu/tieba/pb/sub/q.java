package com.baidu.tieba.pb.sub;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ l bGx;
    private final /* synthetic */ String bGy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, String str) {
        this.bGx = lVar;
        this.bGy = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bGx.hI(this.bGy);
    }
}
