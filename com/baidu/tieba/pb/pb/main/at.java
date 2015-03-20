package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.at {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fc(String str) {
        com.baidu.tieba.tbadkCore.ar arVar;
        bq bqVar;
        this.bIv.aHw = false;
        arVar = this.bIv.aHL;
        if (arVar != null) {
            bqVar = this.bIv.bHT;
            com.baidu.tieba.pb.a.b pbData = bqVar.getPbData();
            if (pbData.YP().getPraise().getIsLike() == 1) {
                this.bIv.eE(0);
            } else {
                this.bIv.eE(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.YP()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fd(String str) {
        com.baidu.tieba.tbadkCore.ar arVar;
        this.bIv.aHw = false;
        arVar = this.bIv.aHL;
        if (arVar != null && str != null) {
            this.bIv.showToast(str);
        }
    }
}
