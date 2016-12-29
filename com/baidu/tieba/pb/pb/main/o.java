package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ag;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class o implements ag.a {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ag.a
    public void hw(String str) {
        com.baidu.tieba.tbadkCore.ag agVar;
        dc dcVar;
        this.eah.dZH = false;
        agVar = this.eah.dZI;
        if (agVar != null) {
            dcVar = this.eah.dYA;
            com.baidu.tieba.pb.data.f pbData = dcVar.getPbData();
            if (pbData.aIl().rv().getIsLike() == 1) {
                this.eah.hw(0);
            } else {
                this.eah.hw(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aIl()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ag.a
    public void H(int i, String str) {
        com.baidu.tieba.tbadkCore.ag agVar;
        this.eah.dZH = false;
        agVar = this.eah.dZI;
        if (agVar != null && str != null) {
            if (AntiHelper.rp(i)) {
                AntiHelper.S(this.eah.getPageContext().getPageActivity(), str);
            } else {
                this.eah.showToast(str);
            }
        }
    }
}
