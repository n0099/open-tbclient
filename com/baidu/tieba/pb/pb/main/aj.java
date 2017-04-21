package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements BdListView.e {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lo() {
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
        z = this.emk.elW;
        if (z && this.emk.aLI()) {
            this.emk.aLK();
        }
        z2 = this.emk.mIsLogin;
        if (z2) {
            pbModel = this.emk.ekv;
            if (!pbModel.iy(false)) {
                pbModel2 = this.emk.ekv;
                if (pbModel2.getPbData() != null) {
                    eyVar3 = this.emk.eli;
                    eyVar3.aOC();
                }
                pbModel3 = this.emk.ekv;
                if (pbModel3 != null) {
                    eyVar = this.emk.eli;
                    if (eyVar != null) {
                        pbModel4 = this.emk.ekv;
                        if (pbModel4.aNa() != null) {
                            pbModel5 = this.emk.ekv;
                            if (pbModel5.aNa().aMo()) {
                                eyVar2 = this.emk.eli;
                                eyVar2.aMx();
                                pbModel6 = this.emk.ekv;
                                pbModel6.aNa().aMq();
                            }
                        }
                    }
                }
            } else {
                eyVar4 = this.emk.eli;
                eyVar4.aOn();
                TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.emk.elW = true;
        }
    }
}
