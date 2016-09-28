package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class p implements ai.a {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void hB(String str) {
        com.baidu.tieba.tbadkCore.ai aiVar;
        dh dhVar;
        this.eqa.epz = false;
        aiVar = this.eqa.bQa;
        if (aiVar != null) {
            dhVar = this.eqa.eov;
            com.baidu.tieba.pb.data.h pbData = dhVar.getPbData();
            if (pbData.aMs().rF().getIsLike() == 1) {
                this.eqa.hS(0);
            } else {
                this.eqa.hS(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aMs()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void v(int i, String str) {
        com.baidu.tieba.tbadkCore.ai aiVar;
        this.eqa.epz = false;
        aiVar = this.eqa.bQa;
        if (aiVar != null && str != null) {
            if (AntiHelper.rU(i)) {
                AntiHelper.R(this.eqa.getPageContext().getPageActivity(), str);
            } else {
                this.eqa.showToast(str);
            }
        }
    }
}
