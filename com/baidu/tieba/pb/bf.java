package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.f2090a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cp cpVar;
        cp cpVar2;
        cp cpVar3;
        cpVar = this.f2090a.y;
        if (!cpVar.x()) {
            cpVar3 = this.f2090a.y;
            cpVar3.b(false);
            return;
        }
        cpVar2 = this.f2090a.y;
        cpVar2.b(true);
    }
}
