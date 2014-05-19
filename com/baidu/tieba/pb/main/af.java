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
        bc bcVar;
        bc bcVar2;
        bcVar = this.a.y;
        if (bcVar != null) {
            bcVar2 = this.a.y;
            bcVar2.s();
        }
    }
}
