package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        dh dhVar;
        dh dhVar2;
        dhVar = this.ebT.eas;
        if (dhVar != null) {
            dhVar2 = this.ebT.eas;
            dhVar2.LoadData();
        }
    }
}
