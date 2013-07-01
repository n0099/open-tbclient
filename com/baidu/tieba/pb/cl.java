package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ch f1256a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ch chVar) {
        this.f1256a = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        cr crVar;
        bkVar = this.f1256a.f1252a;
        crVar = bkVar.z;
        crVar.c();
    }
}
