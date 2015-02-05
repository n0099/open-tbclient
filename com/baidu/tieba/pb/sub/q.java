package com.baidu.tieba.pb.sub;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ l bGw;
    private final /* synthetic */ String bGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, String str) {
        this.bGw = lVar;
        this.bGx = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bGw.hF(this.bGx);
    }
}
