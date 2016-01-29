package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x dOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.dOC = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dOC.postDelayed(this, 2000L);
    }
}
