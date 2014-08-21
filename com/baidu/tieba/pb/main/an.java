package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bsVar = this.a.E;
        if (!bsVar.E()) {
            bsVar3 = this.a.E;
            bsVar3.b(false);
            return;
        }
        bsVar2 = this.a.E;
        bsVar2.b(true);
    }
}
