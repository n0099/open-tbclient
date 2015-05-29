package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x cjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.cjg = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cjg.postDelayed(this, 2000L);
    }
}
