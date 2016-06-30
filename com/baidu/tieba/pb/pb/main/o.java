package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class o implements aj.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void gR(String str) {
        com.baidu.tieba.tbadkCore.aj ajVar;
        dg dgVar;
        this.dPF.bBd = false;
        ajVar = this.dPF.bBp;
        if (ajVar != null) {
            dgVar = this.dPF.dOf;
            com.baidu.tieba.pb.data.h pbData = dgVar.getPbData();
            if (pbData.aDO().getPraise().getIsLike() == 1) {
                this.dPF.hi(0);
            } else {
                this.dPF.hi(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aDO()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void u(int i, String str) {
        com.baidu.tieba.tbadkCore.aj ajVar;
        this.dPF.bBd = false;
        ajVar = this.dPF.bBp;
        if (ajVar != null && str != null) {
            if (AntiHelper.qL(i)) {
                AntiHelper.O(this.dPF.getPageContext().getPageActivity(), str);
            } else {
                this.dPF.showToast(str);
            }
        }
    }
}
