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
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bkVar = this.a.o;
        if (!bkVar.t()) {
            bkVar3 = this.a.o;
            bkVar3.a(false);
            return;
        }
        bkVar2 = this.a.o;
        bkVar2.a(true);
    }
}
