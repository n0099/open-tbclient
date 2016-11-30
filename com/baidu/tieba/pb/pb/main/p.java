package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class p implements ah.a {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ah.a
    public void hB(String str) {
        com.baidu.tieba.tbadkCore.ah ahVar;
        dj djVar;
        this.evL.evl = false;
        ahVar = this.evL.evm;
        if (ahVar != null) {
            djVar = this.evL.euf;
            com.baidu.tieba.pb.data.h pbData = djVar.getPbData();
            if (pbData.aOl().rH().getIsLike() == 1) {
                this.evL.im(0);
            } else {
                this.evL.im(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aOl()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ah.a
    public void L(int i, String str) {
        com.baidu.tieba.tbadkCore.ah ahVar;
        this.evL.evl = false;
        ahVar = this.evL.evm;
        if (ahVar != null && str != null) {
            if (AntiHelper.sm(i)) {
                AntiHelper.S(this.evL.getPageContext().getPageActivity(), str);
            } else {
                this.evL.showToast(str);
            }
        }
    }
}
