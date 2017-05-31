package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class an implements BdListView.e {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        boolean z2;
        PbModel pbModel;
        PbModel pbModel2;
        fx fxVar;
        fx fxVar2;
        z = this.enc.emO;
        if (z && this.enc.aJX()) {
            this.enc.aJZ();
        }
        z2 = this.enc.mIsLogin;
        if (z2) {
            pbModel = this.enc.ele;
            if (!pbModel.ir(false)) {
                pbModel2 = this.enc.ele;
                if (pbModel2.getPbData() != null) {
                    fxVar = this.enc.elU;
                    fxVar.aMN();
                }
            } else {
                fxVar2 = this.enc.elU;
                fxVar2.aMA();
                TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.enc.emO = true;
        }
    }
}
