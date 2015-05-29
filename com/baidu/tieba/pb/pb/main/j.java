package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        boolean z;
        bo boVar;
        ch chVar;
        bo boVar2;
        ch chVar2;
        z = this.bKT.mIsLogin;
        if (z) {
            boVar = this.bKT.bKv;
            if (boVar.dV(false)) {
                chVar2 = this.bKT.bKz;
                chVar2.acg();
                TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            chVar = this.bKT.bKz;
            boVar2 = this.bKT.bKv;
            chVar.h(boVar2.getPbData());
        }
    }
}
