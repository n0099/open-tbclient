package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements BdListView.e {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        boolean z;
        boolean z2;
        dg dgVar;
        es esVar;
        dg dgVar2;
        dg dgVar3;
        es esVar2;
        dg dgVar4;
        dg dgVar5;
        es esVar3;
        dg dgVar6;
        es esVar4;
        z = this.dPF.dPs;
        if (z && this.dPF.aEV()) {
            this.dPF.aEX();
        }
        z2 = this.dPF.mIsLogin;
        if (z2) {
            dgVar = this.dPF.dOf;
            if (dgVar.hw(false)) {
                esVar4 = this.dPF.dOO;
                esVar4.aHo();
                TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            } else {
                esVar = this.dPF.dOO;
                dgVar2 = this.dPF.dOf;
                esVar.m(dgVar2.getPbData());
                dgVar3 = this.dPF.dOf;
                if (dgVar3 != null) {
                    esVar2 = this.dPF.dOO;
                    if (esVar2 != null) {
                        dgVar4 = this.dPF.dOf;
                        if (dgVar4.aGh() != null) {
                            dgVar5 = this.dPF.dOf;
                            if (dgVar5.aGh().aFu()) {
                                esVar3 = this.dPF.dOO;
                                esVar3.aFF();
                                dgVar6 = this.dPF.dOf;
                                dgVar6.aGh().aFw();
                            }
                        }
                    }
                }
            }
            this.dPF.dPs = true;
        }
    }
}
