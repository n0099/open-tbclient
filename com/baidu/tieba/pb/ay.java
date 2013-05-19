package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        bl blVar2;
        bl blVar3;
        blVar = this.a.o;
        if (!blVar.t()) {
            blVar3 = this.a.o;
            blVar3.a(false);
            return;
        }
        blVar2 = this.a.o;
        blVar2.a(true);
    }
}
