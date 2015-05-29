package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ay implements com.baidu.tieba.tbadkCore.at {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fA(String str) {
        com.baidu.tieba.tbadkCore.ar arVar;
        bo boVar;
        this.bKT.aJN = false;
        arVar = this.bKT.aKb;
        if (arVar != null) {
            boVar = this.bKT.bKv;
            com.baidu.tieba.pb.a.b pbData = boVar.getPbData();
            if (pbData.aas().getPraise().getIsLike() == 1) {
                this.bKT.eS(0);
            } else {
                this.bKT.eS(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.aas()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fB(String str) {
        com.baidu.tieba.tbadkCore.ar arVar;
        this.bKT.aJN = false;
        arVar = this.bKT.aKb;
        if (arVar != null && str != null) {
            this.bKT.showToast(str);
        }
    }
}
