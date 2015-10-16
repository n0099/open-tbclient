package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    private final /* synthetic */ PbChosenActivity cfq;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar) {
        this.cfq = pbChosenActivity;
        this.cfr = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.k.c(this.cfq.getPageContext().getPageActivity(), this.cfr.getChatMsgView());
        aVar.dismiss();
    }
}
