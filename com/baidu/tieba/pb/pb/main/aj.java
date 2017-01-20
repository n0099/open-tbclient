package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements BdListView.e {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kp() {
        boolean z;
        boolean z2;
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        ez ezVar;
        PbModel pbModel4;
        PbModel pbModel5;
        ez ezVar2;
        PbModel pbModel6;
        ez ezVar3;
        ez ezVar4;
        z = this.eiV.eiH;
        if (z && this.eiV.aLh()) {
            this.eiV.aLj();
        }
        z2 = this.eiV.mIsLogin;
        if (z2) {
            pbModel = this.eiV.ehh;
            if (!pbModel.iu(false)) {
                pbModel2 = this.eiV.ehh;
                if (pbModel2.getPbData() != null) {
                    ezVar3 = this.eiV.ehV;
                    ezVar3.aNY();
                }
                pbModel3 = this.eiV.ehh;
                if (pbModel3 != null) {
                    ezVar = this.eiV.ehV;
                    if (ezVar != null) {
                        pbModel4 = this.eiV.ehh;
                        if (pbModel4.aMu() != null) {
                            pbModel5 = this.eiV.ehh;
                            if (pbModel5.aMu().aLJ()) {
                                ezVar2 = this.eiV.ehV;
                                ezVar2.aLS();
                                pbModel6 = this.eiV.ehh;
                                pbModel6.aMu().aLL();
                            }
                        }
                    }
                }
            } else {
                ezVar4 = this.eiV.ehV;
                ezVar4.aNK();
                TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.eiV.eiH = true;
        }
    }
}
