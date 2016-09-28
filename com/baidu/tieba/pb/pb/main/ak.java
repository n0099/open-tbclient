package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ak implements BdListView.e {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        boolean z;
        boolean z2;
        dh dhVar;
        ex exVar;
        dh dhVar2;
        dh dhVar3;
        ex exVar2;
        dh dhVar4;
        dh dhVar5;
        ex exVar3;
        dh dhVar6;
        ex exVar4;
        z = this.eqa.epN;
        if (z && this.eqa.aNE()) {
            this.eqa.aNG();
        }
        z2 = this.eqa.mIsLogin;
        if (z2) {
            dhVar = this.eqa.eov;
            if (dhVar.m17if(false)) {
                exVar4 = this.eqa.epe;
                exVar4.aPZ();
                TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            } else {
                exVar = this.eqa.epe;
                dhVar2 = this.eqa.eov;
                exVar.l(dhVar2.getPbData());
                dhVar3 = this.eqa.eov;
                if (dhVar3 != null) {
                    exVar2 = this.eqa.epe;
                    if (exVar2 != null) {
                        dhVar4 = this.eqa.eov;
                        if (dhVar4.aOR() != null) {
                            dhVar5 = this.eqa.eov;
                            if (dhVar5.aOR().aOe()) {
                                exVar3 = this.eqa.epe;
                                exVar3.aOp();
                                dhVar6 = this.eqa.eov;
                                dhVar6.aOR().aOg();
                            }
                        }
                    }
                }
            }
            this.eqa.epN = true;
        }
    }
}
