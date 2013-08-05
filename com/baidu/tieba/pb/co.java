package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class co implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f1509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(ck ckVar) {
        this.f1509a = ckVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        cu cuVar;
        bnVar = this.f1509a.f1505a;
        cuVar = bnVar.z;
        cuVar.c();
    }
}
