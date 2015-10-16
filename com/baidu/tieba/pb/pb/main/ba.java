package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class ba implements ae.a {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void ge(String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        bl blVar;
        this.ciK.aSx = false;
        aeVar = this.ciK.aSJ;
        if (aeVar != null) {
            blVar = this.ciK.cih;
            com.baidu.tieba.pb.a.b pbData = blVar.getPbData();
            if (pbData.aeO().getPraise().getIsLike() == 1) {
                this.ciK.fp(0);
            } else {
                this.ciK.fp(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aeO()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void y(int i, String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        this.ciK.aSx = false;
        aeVar = this.ciK.aSJ;
        if (aeVar != null && str != null) {
            if (AntiHelper.lc(i)) {
                AntiHelper.P(this.ciK.getPageContext().getPageActivity(), str);
            } else {
                this.ciK.showToast(str);
            }
        }
    }
}
