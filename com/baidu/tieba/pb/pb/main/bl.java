package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bl implements Runnable {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        df dfVar;
        df dfVar2;
        dfVar = this.dht.dfV;
        if (dfVar != null) {
            dfVar2 = this.dht.dfV;
            dfVar2.LoadData();
        }
    }
}
