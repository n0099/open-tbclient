package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements a.b {
    private final /* synthetic */ PbChosenActivity bZX;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n bZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar) {
        this.bZX = pbChosenActivity;
        this.bZY = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.k.c(this.bZX.getPageContext().getPageActivity(), this.bZY.getChatMsgView());
        aVar.dismiss();
    }
}
