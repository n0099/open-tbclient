package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.tbadkCore.aq {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fv(String str) {
        com.baidu.tieba.tbadkCore.ao aoVar;
        bq bqVar;
        this.bzj.aAE = false;
        aoVar = this.bzj.aAT;
        if (aoVar != null) {
            bqVar = this.bzj.byJ;
            com.baidu.tieba.tbadkCore.b.i pbData = bqVar.getPbData();
            if (pbData.agE().getPraise().getIsLike() == 1) {
                this.bzj.eB(0);
            } else {
                this.bzj.eB(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.agE()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fw(String str) {
        com.baidu.tieba.tbadkCore.ao aoVar;
        this.bzj.aAE = false;
        aoVar = this.bzj.aAT;
        if (aoVar != null && str != null) {
            this.bzj.showToast(str);
        }
    }
}
