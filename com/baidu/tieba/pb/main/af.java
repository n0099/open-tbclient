package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class af implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bm bmVar;
        bm bmVar2;
        bmVar = this.a.x;
        if (bmVar != null) {
            bmVar2 = this.a.x;
            bmVar2.v();
        }
    }
}
