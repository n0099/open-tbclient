package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f1505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ck ckVar) {
        this.f1505a = ckVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        cu cuVar;
        bnVar = this.f1505a.f1503a;
        cuVar = bnVar.z;
        cuVar.h();
    }
}
