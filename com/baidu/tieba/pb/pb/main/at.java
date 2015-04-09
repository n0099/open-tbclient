package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.at {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void ff(String str) {
        com.baidu.tieba.tbadkCore.ar arVar;
        br brVar;
        this.bIJ.aHE = false;
        arVar = this.bIJ.aHT;
        if (arVar != null) {
            brVar = this.bIJ.bIg;
            com.baidu.tieba.pb.a.b pbData = brVar.getPbData();
            if (pbData.Zb().getPraise().getIsLike() == 1) {
                this.bIJ.eE(0);
            } else {
                this.bIJ.eE(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.Zb()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fg(String str) {
        com.baidu.tieba.tbadkCore.ar arVar;
        this.bIJ.aHE = false;
        arVar = this.bIJ.aHT;
        if (arVar != null && str != null) {
            this.bIJ.showToast(str);
        }
    }
}
