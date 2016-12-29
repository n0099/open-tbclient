package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements BdListView.e {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        boolean z;
        boolean z2;
        dc dcVar;
        dc dcVar2;
        dc dcVar3;
        er erVar;
        dc dcVar4;
        dc dcVar5;
        er erVar2;
        dc dcVar6;
        er erVar3;
        er erVar4;
        z = this.eah.dZU;
        if (z && this.eah.aJu()) {
            this.eah.aJw();
        }
        z2 = this.eah.mIsLogin;
        if (z2) {
            dcVar = this.eah.dYA;
            if (!dcVar.ik(false)) {
                dcVar2 = this.eah.dYA;
                if (dcVar2.getPbData() != null) {
                    erVar3 = this.eah.dZk;
                    erVar3.aMi();
                }
                dcVar3 = this.eah.dYA;
                if (dcVar3 != null) {
                    erVar = this.eah.dZk;
                    if (erVar != null) {
                        dcVar4 = this.eah.dYA;
                        if (dcVar4.aKH() != null) {
                            dcVar5 = this.eah.dYA;
                            if (dcVar5.aKH().aJW()) {
                                erVar2 = this.eah.dZk;
                                erVar2.aKf();
                                dcVar6 = this.eah.dYA;
                                dcVar6.aKH().aJY();
                            }
                        }
                    }
                }
            } else {
                erVar4 = this.eah.dZk;
                erVar4.aLV();
                TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.eah.dZU = true;
        }
    }
}
