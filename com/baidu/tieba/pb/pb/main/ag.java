package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ag implements BdListView.e {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        boolean z;
        boolean z2;
        cw cwVar;
        el elVar;
        cw cwVar2;
        cw cwVar3;
        el elVar2;
        cw cwVar4;
        cw cwVar5;
        el elVar3;
        cw cwVar6;
        el elVar4;
        z = this.djE.djr;
        if (z && this.djE.awP()) {
            this.djE.awR();
        }
        z2 = this.djE.mIsLogin;
        if (z2) {
            cwVar = this.djE.dih;
            if (cwVar.gE(false)) {
                elVar4 = this.djE.diR;
                elVar4.aze();
                TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            } else {
                elVar = this.djE.diR;
                cwVar2 = this.djE.dih;
                elVar.n(cwVar2.getPbData());
                cwVar3 = this.djE.dih;
                if (cwVar3 != null) {
                    elVar2 = this.djE.diR;
                    if (elVar2 != null) {
                        cwVar4 = this.djE.dih;
                        if (cwVar4.axY() != null) {
                            cwVar5 = this.djE.dih;
                            if (cwVar5.axY().axm()) {
                                elVar3 = this.djE.diR;
                                elVar3.axx();
                                cwVar6 = this.djE.dih;
                                cwVar6.axY().axo();
                            }
                        }
                    }
                }
            }
            this.djE.djr = true;
        }
    }
}
