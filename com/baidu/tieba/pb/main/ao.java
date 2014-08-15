package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bsVar = this.a.D;
        if (!bsVar.E()) {
            bsVar3 = this.a.D;
            bsVar3.b(false);
            return;
        }
        bsVar2 = this.a.D;
        bsVar2.b(true);
    }
}
