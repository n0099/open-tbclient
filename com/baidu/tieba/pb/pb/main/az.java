package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        dg dgVar;
        dg dgVar2;
        dgVar = this.dPF.dOf;
        if (dgVar != null) {
            dgVar2 = this.dPF.dOf;
            dgVar2.LoadData();
        }
    }
}
