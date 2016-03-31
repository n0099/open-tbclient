package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class an implements BdListView.e {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        boolean z;
        boolean z2;
        df dfVar;
        eu euVar;
        df dfVar2;
        df dfVar3;
        eu euVar2;
        df dfVar4;
        df dfVar5;
        eu euVar3;
        df dfVar6;
        eu euVar4;
        z = this.dht.dhg;
        if (z && this.dht.awE()) {
            this.dht.awG();
        }
        z2 = this.dht.mIsLogin;
        if (z2) {
            dfVar = this.dht.dfV;
            if (dfVar.gb(false)) {
                euVar4 = this.dht.dgF;
                euVar4.ayF();
                TiebaStatic.eventStat(this.dht.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            } else {
                euVar = this.dht.dgF;
                dfVar2 = this.dht.dfV;
                euVar.l(dfVar2.getPbData());
                dfVar3 = this.dht.dfV;
                if (dfVar3 != null) {
                    euVar2 = this.dht.dgF;
                    if (euVar2 != null) {
                        dfVar4 = this.dht.dfV;
                        if (dfVar4.axA() != null) {
                            dfVar5 = this.dht.dfV;
                            if (dfVar5.axA().awS()) {
                                euVar3 = this.dht.dgF;
                                euVar3.ayK();
                                dfVar6 = this.dht.dfV;
                                dfVar6.axA().awU();
                            }
                        }
                    }
                }
            }
            this.dht.dhg = true;
        }
    }
}
