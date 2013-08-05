package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f1507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ck ckVar) {
        this.f1507a = ckVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        cu cuVar;
        bnVar = this.f1507a.f1505a;
        cuVar = bnVar.z;
        cuVar.h();
    }
}
