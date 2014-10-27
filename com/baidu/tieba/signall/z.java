package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x bLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bLC = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bLC.postDelayed(this, 2000L);
    }
}
