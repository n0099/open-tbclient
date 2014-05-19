package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bjVar = this.a.E;
        if (!bjVar.D()) {
            bjVar3 = this.a.E;
            bjVar3.b(false);
            return;
        }
        bjVar2 = this.a.E;
        bjVar2.b(true);
    }
}
