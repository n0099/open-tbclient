package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bd implements Runnable {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        dc dcVar;
        dc dcVar2;
        dcVar = this.eah.dYA;
        if (dcVar != null) {
            dcVar2 = this.eah.dYA;
            dcVar2.LoadData();
        }
    }
}
