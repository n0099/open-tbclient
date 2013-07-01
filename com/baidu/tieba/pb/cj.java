package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ch f1254a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar) {
        this.f1254a = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        cr crVar;
        bkVar = this.f1254a.f1252a;
        crVar = bkVar.z;
        crVar.h();
    }
}
