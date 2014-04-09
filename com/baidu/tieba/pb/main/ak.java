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
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bmVar = this.a.D;
        if (!bmVar.D()) {
            bmVar3 = this.a.D;
            bmVar3.b(false);
            return;
        }
        bmVar2 = this.a.D;
        bmVar2.b(true);
    }
}
