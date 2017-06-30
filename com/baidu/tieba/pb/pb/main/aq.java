package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aq implements BdListView.e {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        boolean z2;
        PbModel pbModel;
        PbModel pbModel2;
        gg ggVar;
        gg ggVar2;
        z = this.ewh.evS;
        if (z && this.ewh.aNU()) {
            this.ewh.aNW();
        }
        z2 = this.ewh.mIsLogin;
        if (z2) {
            pbModel = this.ewh.eue;
            if (!pbModel.iN(false)) {
                pbModel2 = this.ewh.eue;
                if (pbModel2.getPbData() != null) {
                    ggVar = this.ewh.euU;
                    ggVar.aQL();
                }
            } else {
                ggVar2 = this.ewh.euU;
                ggVar2.aQy();
                TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.ewh.evS = true;
        }
    }
}
