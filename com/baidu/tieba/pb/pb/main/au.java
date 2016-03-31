package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.b.a;
/* loaded from: classes.dex */
class au implements a.InterfaceC0059a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.b.a.InterfaceC0059a
    public void N(int i, int i2) {
        eu euVar;
        if (H(i2)) {
            euVar = this.dht.dgF;
            euVar.azi();
        }
    }

    @Override // com.baidu.tieba.b.a.InterfaceC0059a
    public void O(int i, int i2) {
        eu euVar;
        eu euVar2;
        eu euVar3;
        if (H(i2)) {
            euVar = this.dht.dgF;
            euVar.azh();
            if (this.dht.awE()) {
                euVar2 = this.dht.dgF;
                euVar2.ayq();
                euVar3 = this.dht.dgF;
                euVar3.ayr();
            }
        }
    }

    private boolean H(float f) {
        return Math.abs(f) >= 1.0f;
    }
}
