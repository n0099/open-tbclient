package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ak implements BdListView.e {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        boolean z;
        boolean z2;
        PbModel pbModel;
        PbModel pbModel2;
        fm fmVar;
        fm fmVar2;
        z = this.ehy.ehk;
        if (z && this.ehy.aJf()) {
            this.ehy.aJh();
        }
        z2 = this.ehy.mIsLogin;
        if (z2) {
            pbModel = this.ehy.efE;
            if (!pbModel.ic(false)) {
                pbModel2 = this.ehy.efE;
                if (pbModel2.getPbData() != null) {
                    fmVar = this.ehy.egt;
                    fmVar.aLT();
                }
            } else {
                fmVar2 = this.ehy.egt;
                fmVar2.aLE();
                TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            }
            this.ehy.ehk = true;
        }
    }
}
