package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.b {
    private final /* synthetic */ PbChosenActivity cCa;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cCb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar) {
        this.cCa = pbChosenActivity;
        this.cCb = mVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.k.c(this.cCa.getPageContext().getPageActivity(), this.cCb.getChatMsgView());
        aVar.dismiss();
    }
}
