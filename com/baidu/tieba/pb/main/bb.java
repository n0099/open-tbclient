package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bb implements com.baidu.tieba.tbadkCore.aq {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fx(String str) {
        com.baidu.tieba.tbadkCore.ao aoVar;
        bq bqVar;
        this.bAS.aBD = false;
        aoVar = this.bAS.aBR;
        if (aoVar != null) {
            bqVar = this.bAS.bAr;
            com.baidu.tieba.tbadkCore.b.i pbData = bqVar.getPbData();
            if (pbData.ahe().getPraise().getIsLike() == 1) {
                this.bAS.eH(0);
            } else {
                this.bAS.eH(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.ahe()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fy(String str) {
        com.baidu.tieba.tbadkCore.ao aoVar;
        this.bAS.aBD = false;
        aoVar = this.bAS.aBR;
        if (aoVar != null && str != null) {
            this.bAS.showToast(str);
        }
    }
}
