package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x cjh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.cjh = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cjh.postDelayed(this, 2000L);
    }
}
