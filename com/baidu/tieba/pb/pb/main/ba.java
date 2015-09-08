package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes.dex */
class ba implements ae.a {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void gb(String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        bk bkVar;
        this.ccj.aTq = false;
        aeVar = this.ccj.aTC;
        if (aeVar != null) {
            bkVar = this.ccj.cbG;
            com.baidu.tieba.pb.a.b pbData = bkVar.getPbData();
            if (pbData.acQ().getPraise().getIsLike() == 1) {
                this.ccj.fk(0);
            } else {
                this.ccj.fk(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.acQ()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void bF(String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        this.ccj.aTq = false;
        aeVar = this.ccj.aTC;
        if (aeVar != null && str != null) {
            this.ccj.showToast(str);
        }
    }
}
