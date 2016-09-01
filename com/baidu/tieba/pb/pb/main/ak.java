package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ak implements BdListView.e {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.eob = pbActivity;
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
        z = this.eob.enO;
        if (z && this.eob.aMY()) {
            this.eob.aNa();
        }
        z2 = this.eob.mIsLogin;
        if (z2) {
            dhVar = this.eob.emx;
            if (dhVar.ic(false)) {
                exVar4 = this.eob.enh;
                exVar4.aPq();
                TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            } else {
                exVar = this.eob.enh;
                dhVar2 = this.eob.emx;
                exVar.m(dhVar2.getPbData());
                dhVar3 = this.eob.emx;
                if (dhVar3 != null) {
                    exVar2 = this.eob.enh;
                    if (exVar2 != null) {
                        dhVar4 = this.eob.emx;
                        if (dhVar4.aOj() != null) {
                            dhVar5 = this.eob.emx;
                            if (dhVar5.aOj().aNw()) {
                                exVar3 = this.eob.enh;
                                exVar3.aNH();
                                dhVar6 = this.eob.emx;
                                dhVar6.aOj().aNy();
                            }
                        }
                    }
                }
            }
            this.eob.enO = true;
        }
    }
}
