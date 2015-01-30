package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x bRS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bRS = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRS.postDelayed(this, 2000L);
    }
}
