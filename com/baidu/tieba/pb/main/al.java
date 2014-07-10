package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bt btVar;
        bt btVar2;
        bt btVar3;
        btVar = this.a.D;
        if (!btVar.E()) {
            btVar3 = this.a.D;
            btVar3.b(false);
            return;
        }
        btVar2 = this.a.D;
        btVar2.b(true);
    }
}
