package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(NewPbActivity newPbActivity) {
        this.f1551a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        br brVar2;
        br brVar3;
        brVar = this.f1551a.t;
        if (!brVar.E()) {
            brVar3 = this.f1551a.t;
            brVar3.b(false);
            return;
        }
        brVar2 = this.f1551a.t;
        brVar2.b(true);
    }
}
