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
        crVar = this.a.x;
        if (!crVar.x()) {
            crVar3 = this.a.x;
            crVar3.b(false);
            return;
        }
        crVar2 = this.a.x;
        crVar2.b(true);
    }
}
