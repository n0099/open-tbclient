package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x ehb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.ehb = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ehb.postDelayed(this, 2000L);
    }
}
