package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.f1506a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        bo boVar2;
        bo boVar3;
        boVar = this.f1506a.q;
        if (!boVar.u()) {
            boVar3 = this.f1506a.q;
            boVar3.b(false);
            return;
        }
        boVar2 = this.f1506a.q;
        boVar2.b(true);
    }
}
