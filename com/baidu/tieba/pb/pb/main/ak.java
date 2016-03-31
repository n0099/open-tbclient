package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class ak implements PbActivity.c {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.c
    public void fZ(boolean z) {
        df dfVar;
        eu euVar;
        df dfVar2;
        eu euVar2;
        dfVar = this.dht.dfV;
        if (dfVar.gc(true)) {
            euVar2 = this.dht.dgF;
            euVar2.ayG();
            return;
        }
        euVar = this.dht.dgF;
        euVar.azf();
        dfVar2 = this.dht.dfV;
        dfVar2.lY(1);
    }
}
