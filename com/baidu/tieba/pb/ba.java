package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.f2064a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bt btVar;
        bt btVar2;
        bt btVar3;
        btVar = this.f2064a.u;
        if (!btVar.E()) {
            btVar3 = this.f2064a.u;
            btVar3.b(false);
            return;
        }
        btVar2 = this.f2064a.u;
        btVar2.b(true);
    }
}
