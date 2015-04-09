package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x cfc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.cfc = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cfc.postDelayed(this, 2000L);
    }
}
