package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class aw implements Runnable {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cw cwVar;
        cw cwVar2;
        cwVar = this.djE.dih;
        if (cwVar != null) {
            cwVar2 = this.djE.dih;
            cwVar2.LoadData();
        }
    }
}
