package com.baidu.tieba.pb.chosen;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ PbChosenActivity bJf;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.l bJg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.l lVar) {
        this.bJf = pbChosenActivity;
        this.bJg = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.lib.util.n.c(this.bJf.getPageContext().getPageActivity(), this.bJg.getChatMsgView());
        aVar.dismiss();
    }
}
