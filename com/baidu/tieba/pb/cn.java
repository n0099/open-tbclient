package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cl f1543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cl clVar) {
        this.f1543a = clVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        cv cvVar;
        boVar = this.f1543a.f1541a;
        cvVar = boVar.A;
        cvVar.h();
    }
}
