package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bkVar = this.a.D;
        if (!bkVar.D()) {
            bkVar3 = this.a.D;
            bkVar3.b(false);
            return;
        }
        bkVar2 = this.a.D;
        bkVar2.b(true);
    }
}
