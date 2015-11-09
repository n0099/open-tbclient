package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    private final /* synthetic */ PbChosenActivity cfR;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar) {
        this.cfR = pbChosenActivity;
        this.cfS = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.k.c(this.cfR.getPageContext().getPageActivity(), this.cfS.getChatMsgView());
        aVar.dismiss();
    }
}
