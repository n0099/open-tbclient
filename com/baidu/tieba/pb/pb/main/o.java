package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class o implements aj.a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void gR(String str) {
        com.baidu.tieba.tbadkCore.aj ajVar;
        dh dhVar;
        this.ebT.ebu = false;
        ajVar = this.ebT.bEB;
        if (ajVar != null) {
            dhVar = this.ebT.eas;
            com.baidu.tieba.pb.data.h pbData = dhVar.getPbData();
            if (pbData.aGY().qp().getIsLike() == 1) {
                this.ebT.hl(0);
            } else {
                this.ebT.hl(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aGY()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void u(int i, String str) {
        com.baidu.tieba.tbadkCore.aj ajVar;
        this.ebT.ebu = false;
        ajVar = this.ebT.bEB;
        if (ajVar != null && str != null) {
            if (AntiHelper.rg(i)) {
                AntiHelper.O(this.ebT.getPageContext().getPageActivity(), str);
            } else {
                this.ebT.showToast(str);
            }
        }
    }
}
