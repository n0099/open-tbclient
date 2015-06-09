package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        boolean z;
        bo boVar;
        ch chVar;
        bo boVar2;
        ch chVar2;
        z = this.bKU.mIsLogin;
        if (z) {
            boVar = this.bKU.bKw;
            if (boVar.dV(false)) {
                chVar2 = this.bKU.bKA;
                chVar2.ach();
                TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            chVar = this.bKU.bKA;
            boVar2 = this.bKU.bKw;
            chVar.h(boVar2.getPbData());
        }
    }
}
