package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ak implements BdListView.e {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        boolean z;
        boolean z2;
        dj djVar;
        dj djVar2;
        dj djVar3;
        ey eyVar;
        dj djVar4;
        dj djVar5;
        ey eyVar2;
        dj djVar6;
        ey eyVar3;
        ey eyVar4;
        z = this.evL.evy;
        if (z && this.evL.aPv()) {
            this.evL.aPx();
        }
        z2 = this.evL.mIsLogin;
        if (z2) {
            djVar = this.evL.euf;
            if (!djVar.ix(false)) {
                djVar2 = this.evL.euf;
                if (djVar2.getPbData() != null) {
                    eyVar3 = this.evL.euP;
                    eyVar3.aSo();
                }
                djVar3 = this.evL.euf;
                if (djVar3 != null) {
                    eyVar = this.evL.euP;
                    if (eyVar != null) {
                        djVar4 = this.evL.euf;
                        if (djVar4.aQK() != null) {
                            djVar5 = this.evL.euf;
                            if (djVar5.aQK().aPX()) {
                                eyVar2 = this.evL.euP;
                                eyVar2.aQi();
                                djVar6 = this.evL.euf;
                                djVar6.aQK().aPZ();
                            }
                        }
                    }
                }
            } else {
                eyVar4 = this.evL.euP;
                eyVar4.aSb();
                TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.evL.evy = true;
        }
    }
}
