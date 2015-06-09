package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ay implements com.baidu.tieba.tbadkCore.at {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fA(String str) {
        com.baidu.tieba.tbadkCore.ar arVar;
        bo boVar;
        this.bKU.aJO = false;
        arVar = this.bKU.aKc;
        if (arVar != null) {
            boVar = this.bKU.bKw;
            com.baidu.tieba.pb.a.b pbData = boVar.getPbData();
            if (pbData.aat().getPraise().getIsLike() == 1) {
                this.bKU.eS(0);
            } else {
                this.bKU.eS(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.aat()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fB(String str) {
        com.baidu.tieba.tbadkCore.ar arVar;
        this.bKU.aJO = false;
        arVar = this.bKU.aKc;
        if (arVar != null && str != null) {
            this.bKU.showToast(str);
        }
    }
}
