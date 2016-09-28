package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bc implements Runnable {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        dh dhVar;
        dh dhVar2;
        dhVar = this.eqa.eov;
        if (dhVar != null) {
            dhVar2 = this.eqa.eov;
            dhVar2.LoadData();
        }
    }
}
