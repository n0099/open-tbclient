package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cr crVar;
        cr crVar2;
        cr crVar3;
        crVar = this.a.A;
        if (!crVar.y()) {
            crVar3 = this.a.A;
            crVar3.b(false);
            return;
        }
        crVar2 = this.a.A;
        crVar2.b(true);
    }
}
