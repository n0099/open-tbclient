package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.postDelayed(this, 2000L);
    }
}
