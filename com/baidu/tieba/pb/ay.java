package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.f1216a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bkVar = this.f1216a.p;
        if (!bkVar.t()) {
            bkVar3 = this.f1216a.p;
            bkVar3.b(false);
            return;
        }
        bkVar2 = this.f1216a.p;
        bkVar2.b(true);
    }
}
