package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class g implements ae.a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void gx(String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        cm cmVar;
        this.cNq.bee = false;
        aeVar = this.cNq.beq;
        if (aeVar != null) {
            cmVar = this.cNq.cMF;
            com.baidu.tieba.pb.a.c pbData = cmVar.getPbData();
            if (pbData.aoF().getPraise().getIsLike() == 1) {
                this.cNq.gl(0);
            } else {
                this.cNq.gl(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aoF()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void y(int i, String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        this.cNq.bee = false;
        aeVar = this.cNq.beq;
        if (aeVar != null && str != null) {
            if (AntiHelper.or(i)) {
                AntiHelper.X(this.cNq.getPageContext().getPageActivity(), str);
            } else {
                this.cNq.showToast(str);
            }
        }
    }
}
