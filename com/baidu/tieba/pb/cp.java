package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cl f1545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cl clVar) {
        this.f1545a = clVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        cv cvVar;
        boVar = this.f1545a.f1541a;
        cvVar = boVar.A;
        cvVar.c();
    }
}
