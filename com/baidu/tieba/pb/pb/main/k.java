package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        br brVar;
        cj cjVar;
        br brVar2;
        cj cjVar2;
        brVar = this.bIJ.bIg;
        if (brVar.dK(false)) {
            cjVar2 = this.bIJ.bIl;
            cjVar2.aaY();
            TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        cjVar = this.bIJ.bIl;
        brVar2 = this.bIJ.bIg;
        cjVar.h(brVar2.getPbData());
    }
}
