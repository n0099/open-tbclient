package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cl implements Runnable {
    final /* synthetic */ ch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ch chVar) {
        this.a = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        cr crVar;
        bkVar = this.a.a;
        crVar = bkVar.z;
        crVar.c();
    }
}
