package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class aj extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        eu euVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        df dfVar;
        if (obj != null) {
            aVar2 = this.dht.dgC;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    dfVar = this.dht.dfV;
                    dfVar.axq();
                    this.dht.a((a.b) obj);
                    return;
                case 1:
                    this.dht.a((a.d) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.dht;
                    aVar3 = this.dht.dgC;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    this.dht.a((a.f) obj);
                    return;
                default:
                    return;
            }
        }
        euVar = this.dht.dgF;
        aVar = this.dht.dgC;
        euVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
