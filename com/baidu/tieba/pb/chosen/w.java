package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements a.b {
    private final /* synthetic */ PbChosenActivity bZd;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n bZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar) {
        this.bZd = pbChosenActivity;
        this.bZe = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.k.c(this.bZd.getPageContext().getPageActivity(), this.bZe.getChatMsgView());
        aVar.dismiss();
    }
}
