package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class ag implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bf bfVar;
        bf bfVar2;
        bfVar = this.a.x;
        if (bfVar != null) {
            bfVar2 = this.a.x;
            bfVar2.s();
        }
    }
}
