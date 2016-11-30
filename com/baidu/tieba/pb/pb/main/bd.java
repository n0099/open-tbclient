package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bd implements Runnable {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        dj djVar;
        dj djVar2;
        djVar = this.evL.euf;
        if (djVar != null) {
            djVar2 = this.evL.euf;
            djVar2.LoadData();
        }
    }
}
