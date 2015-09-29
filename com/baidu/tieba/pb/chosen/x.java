package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements a.b {
    private final /* synthetic */ PbChosenActivity cff;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar) {
        this.cff = pbChosenActivity;
        this.cfg = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.k.c(this.cff.getPageContext().getPageActivity(), this.cfg.getChatMsgView());
        aVar.dismiss();
    }
}
