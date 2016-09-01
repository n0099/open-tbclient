package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class p implements ai.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void hu(String str) {
        com.baidu.tieba.tbadkCore.ai aiVar;
        dh dhVar;
        this.eob.enC = false;
        aiVar = this.eob.bQh;
        if (aiVar != null) {
            dhVar = this.eob.emx;
            com.baidu.tieba.pb.data.h pbData = dhVar.getPbData();
            if (pbData.aLQ().rt().getIsLike() == 1) {
                this.eob.hO(0);
            } else {
                this.eob.hO(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aLQ()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void v(int i, String str) {
        com.baidu.tieba.tbadkCore.ai aiVar;
        this.eob.enC = false;
        aiVar = this.eob.bQh;
        if (aiVar != null && str != null) {
            if (AntiHelper.rG(i)) {
                AntiHelper.R(this.eob.getPageContext().getPageActivity(), str);
            } else {
                this.eob.showToast(str);
            }
        }
    }
}
