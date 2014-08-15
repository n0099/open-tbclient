package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        bl blVar2;
        blVar = this.a.x;
        if (blVar != null) {
            blVar2 = this.a.x;
            blVar2.v();
        }
    }
}
