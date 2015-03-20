package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x ceN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.ceN = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ceN.postDelayed(this, 2000L);
    }
}
