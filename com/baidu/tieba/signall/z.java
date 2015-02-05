package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x bRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bRR = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRR.postDelayed(this, 2000L);
    }
}
