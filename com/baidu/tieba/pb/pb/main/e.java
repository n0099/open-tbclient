package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class e implements ae.a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void gg(String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        ca caVar;
        this.cjN.aSF = false;
        aeVar = this.cjN.aSR;
        if (aeVar != null) {
            caVar = this.cjN.cjj;
            com.baidu.tieba.pb.a.c pbData = caVar.getPbData();
            if (pbData.afh().getPraise().getIsLike() == 1) {
                this.cjN.fx(0);
            } else {
                this.cjN.fx(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.afh()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void x(int i, String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        this.cjN.aSF = false;
        aeVar = this.cjN.aSR;
        if (aeVar != null && str != null) {
            if (AntiHelper.lr(i)) {
                AntiHelper.Q(this.cjN.getPageContext().getPageActivity(), str);
            } else {
                this.cjN.showToast(str);
            }
        }
    }
}
