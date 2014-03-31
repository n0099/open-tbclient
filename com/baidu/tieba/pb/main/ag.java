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
        bd bdVar;
        bd bdVar2;
        bdVar = this.a.x;
        if (bdVar != null) {
            bdVar2 = this.a.x;
            bdVar2.s();
        }
    }
}
