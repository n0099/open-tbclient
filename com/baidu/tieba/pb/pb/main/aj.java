package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements BdListView.e {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jC() {
        boolean z;
        boolean z2;
        dh dhVar;
        ew ewVar;
        dh dhVar2;
        dh dhVar3;
        ew ewVar2;
        dh dhVar4;
        dh dhVar5;
        ew ewVar3;
        dh dhVar6;
        ew ewVar4;
        z = this.ebT.ebG;
        if (z && this.ebT.aIg()) {
            this.ebT.aIi();
        }
        z2 = this.ebT.mIsLogin;
        if (z2) {
            dhVar = this.ebT.eas;
            if (dhVar.hH(false)) {
                ewVar4 = this.ebT.ebb;
                ewVar4.aKz();
                TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            } else {
                ewVar = this.ebT.ebb;
                dhVar2 = this.ebT.eas;
                ewVar.m(dhVar2.getPbData());
                dhVar3 = this.ebT.eas;
                if (dhVar3 != null) {
                    ewVar2 = this.ebT.ebb;
                    if (ewVar2 != null) {
                        dhVar4 = this.ebT.eas;
                        if (dhVar4.aJs() != null) {
                            dhVar5 = this.ebT.eas;
                            if (dhVar5.aJs().aIF()) {
                                ewVar3 = this.ebT.ebb;
                                ewVar3.aIQ();
                                dhVar6 = this.ebT.eas;
                                dhVar6.aJs().aIH();
                            }
                        }
                    }
                }
            }
            this.ebT.ebG = true;
        }
    }
}
