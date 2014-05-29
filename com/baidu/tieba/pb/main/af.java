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
        bj bjVar;
        bj bjVar2;
        bjVar = this.a.x;
        if (bjVar != null) {
            bjVar2 = this.a.x;
            bjVar2.t();
        }
    }
}
