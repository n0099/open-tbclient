package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.postDelayed(this, 2000L);
    }
}
