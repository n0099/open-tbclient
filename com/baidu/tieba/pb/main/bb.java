package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.tbadkCore.aq {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fA(String str) {
        com.baidu.tieba.tbadkCore.ao aoVar;
        bq bqVar;
        this.bAT.aBG = false;
        aoVar = this.bAT.aBU;
        if (aoVar != null) {
            bqVar = this.bAT.bAs;
            com.baidu.tieba.tbadkCore.b.i pbData = bqVar.getPbData();
            if (pbData.ahj().getPraise().getIsLike() == 1) {
                this.bAT.eH(0);
            } else {
                this.bAT.eH(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.ahj()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fB(String str) {
        com.baidu.tieba.tbadkCore.ao aoVar;
        this.bAT.aBG = false;
        aoVar = this.bAT.aBU;
        if (aoVar != null && str != null) {
            this.bAT.showToast(str);
        }
    }
}
