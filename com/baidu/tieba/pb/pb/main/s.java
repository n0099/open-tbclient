package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class s implements BdListView.e {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        ca caVar;
        ct ctVar;
        ca caVar2;
        ct ctVar2;
        z = this.cjN.mIsLogin;
        if (z) {
            caVar = this.cjN.cjj;
            if (caVar.eA(false)) {
                ctVar2 = this.cjN.cjo;
                ctVar2.ahb();
                TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            ctVar = this.cjN.cjo;
            caVar2 = this.cjN.cjj;
            ctVar.k(caVar2.getPbData());
        }
    }
}
