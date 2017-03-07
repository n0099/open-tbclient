package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements BdListView.e {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lj() {
        boolean z;
        boolean z2;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        fa faVar;
        PbModel pbModel4;
        PbModel pbModel5;
        fa faVar2;
        PbModel pbModel6;
        fa faVar3;
        fa faVar4;
        z = this.elO.elA;
        if (z && this.elO.aKC()) {
            this.elO.aKE();
        }
        z2 = this.elO.mIsLogin;
        if (z2) {
            pbModel = this.elO.ejZ;
            if (!pbModel.ip(false)) {
                pbModel2 = this.elO.ejZ;
                if (pbModel2.getPbData() != null) {
                    faVar3 = this.elO.ekM;
                    faVar3.aNs();
                }
                pbModel3 = this.elO.ejZ;
                if (pbModel3 != null) {
                    faVar = this.elO.ekM;
                    if (faVar != null) {
                        pbModel4 = this.elO.ejZ;
                        if (pbModel4.aLQ() != null) {
                            pbModel5 = this.elO.ejZ;
                            if (pbModel5.aLQ().aLf()) {
                                faVar2 = this.elO.ekM;
                                faVar2.aLo();
                                pbModel6 = this.elO.ejZ;
                                pbModel6.aLQ().aLh();
                            }
                        }
                    }
                }
            } else {
                faVar4 = this.elO.ekM;
                faVar4.aNd();
                TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.elO.elA = true;
        }
    }
}
