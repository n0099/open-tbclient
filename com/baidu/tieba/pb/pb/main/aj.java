package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements BdListView.e {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        boolean z;
        boolean z2;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        ey eyVar;
        PbModel pbModel4;
        PbModel pbModel5;
        ey eyVar2;
        PbModel pbModel6;
        ey eyVar3;
        ey eyVar4;
        z = this.ejU.ejG;
        if (z && this.ejU.aKI()) {
            this.ejU.aKK();
        }
        z2 = this.ejU.mIsLogin;
        if (z2) {
            pbModel = this.ejU.eif;
            if (!pbModel.io(false)) {
                pbModel2 = this.ejU.eif;
                if (pbModel2.getPbData() != null) {
                    eyVar3 = this.ejU.eiS;
                    eyVar3.aNB();
                }
                pbModel3 = this.ejU.eif;
                if (pbModel3 != null) {
                    eyVar = this.ejU.eiS;
                    if (eyVar != null) {
                        pbModel4 = this.ejU.eif;
                        if (pbModel4.aLZ() != null) {
                            pbModel5 = this.ejU.eif;
                            if (pbModel5.aLZ().aLn()) {
                                eyVar2 = this.ejU.eiS;
                                eyVar2.aLw();
                                pbModel6 = this.ejU.eif;
                                pbModel6.aLZ().aLp();
                            }
                        }
                    }
                }
            } else {
                eyVar4 = this.ejU.eiS;
                eyVar4.aNm();
                TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.ejU.ejG = true;
        }
    }
}
