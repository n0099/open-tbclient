package com.baidu.tieba.pb.sub;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ l bEM;
    private final /* synthetic */ String bEN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, String str) {
        this.bEM = lVar;
        this.bEN = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bEM.hB(this.bEN);
    }
}
