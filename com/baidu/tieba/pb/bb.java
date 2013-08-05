package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1470a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewPbActivity newPbActivity) {
        this.f1470a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bnVar = this.f1470a.p;
        if (!bnVar.t()) {
            bnVar3 = this.f1470a.p;
            bnVar3.b(false);
            return;
        }
        bnVar2 = this.f1470a.p;
        bnVar2.b(true);
    }
}
