package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class f implements af.a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void gt(String str) {
        com.baidu.tieba.tbadkCore.af afVar;
        cc ccVar;
        this.cCm.aXT = false;
        afVar = this.cCm.aYf;
        if (afVar != null) {
            ccVar = this.cCm.cBG;
            com.baidu.tieba.pb.a.c pbData = ccVar.getPbData();
            if (pbData.ajz().getPraise().getIsLike() == 1) {
                this.cCm.fU(0);
            } else {
                this.cCm.fU(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.ajz()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void y(int i, String str) {
        com.baidu.tieba.tbadkCore.af afVar;
        this.cCm.aXT = false;
        afVar = this.cCm.aYf;
        if (afVar != null && str != null) {
            if (AntiHelper.mC(i)) {
                AntiHelper.Q(this.cCm.getPageContext().getPageActivity(), str);
            } else {
                this.cCm.showToast(str);
            }
        }
    }
}
