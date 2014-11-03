package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x bLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bLR = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bLR.postDelayed(this, 2000L);
    }
}
