package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x dyy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.dyy = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dyy.postDelayed(this, 2000L);
    }
}
