package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bc implements Runnable {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        dh dhVar;
        dh dhVar2;
        dhVar = this.eob.emx;
        if (dhVar != null) {
            dhVar2 = this.eob.emx;
            dhVar2.LoadData();
        }
    }
}
