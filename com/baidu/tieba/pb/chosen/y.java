package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.b {
    private final /* synthetic */ PbChosenActivity cyt;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cyu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar) {
        this.cyt = pbChosenActivity;
        this.cyu = mVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.k.c(this.cyt.getPageContext().getPageActivity(), this.cyu.getChatMsgView());
        aVar.dismiss();
    }
}
