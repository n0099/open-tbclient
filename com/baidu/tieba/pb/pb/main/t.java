package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class t implements BdListView.e {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        cc ccVar;
        da daVar;
        cc ccVar2;
        da daVar2;
        z = this.cCm.mIsLogin;
        if (z) {
            ccVar = this.cCm.cBG;
            if (ccVar.fd(false)) {
                daVar2 = this.cCm.cBL;
                daVar2.alz();
                TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            daVar = this.cCm.cBL;
            ccVar2 = this.cCm.cBG;
            daVar.l(ccVar2.getPbData());
        }
    }
}
