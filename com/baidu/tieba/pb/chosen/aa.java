package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements a.b {
    private final /* synthetic */ PbChosenActivity cIF;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar) {
        this.cIF = pbChosenActivity;
        this.cIG = mVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.k.c(this.cIF.getPageContext().getPageActivity(), this.cIG.getChatMsgView());
        aVar.dismiss();
    }
}
