package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes.dex */
class ba implements ad.a {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void fU(String str) {
        com.baidu.tieba.tbadkCore.ad adVar;
        bk bkVar;
        this.cbo.aTc = false;
        adVar = this.cbo.aTo;
        if (adVar != null) {
            bkVar = this.cbo.caL;
            com.baidu.tieba.pb.a.b pbData = bkVar.getPbData();
            if (pbData.acH().getPraise().getIsLike() == 1) {
                this.cbo.fd(0);
            } else {
                this.cbo.fd(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.acH()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void bF(String str) {
        com.baidu.tieba.tbadkCore.ad adVar;
        this.cbo.aTc = false;
        adVar = this.cbo.aTo;
        if (adVar != null && str != null) {
            this.cbo.showToast(str);
        }
    }
}
