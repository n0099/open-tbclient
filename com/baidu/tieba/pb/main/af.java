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
        bl blVar;
        bl blVar2;
        blVar = this.a.y;
        if (blVar != null) {
            blVar2 = this.a.y;
            blVar2.v();
        }
    }
}
