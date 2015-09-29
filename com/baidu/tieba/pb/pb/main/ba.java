package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class ba implements ae.a {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void ge(String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        bl blVar;
        this.ciz.aSm = false;
        aeVar = this.ciz.aSy;
        if (aeVar != null) {
            blVar = this.ciz.chV;
            com.baidu.tieba.pb.a.b pbData = blVar.getPbData();
            if (pbData.aeO().getPraise().getIsLike() == 1) {
                this.ciz.fp(0);
            } else {
                this.ciz.fp(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aeO()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void y(int i, String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        this.ciz.aSm = false;
        aeVar = this.ciz.aSy;
        if (aeVar != null && str != null) {
            if (AntiHelper.la(i)) {
                AntiHelper.P(this.ciz.getPageContext().getPageActivity(), str);
            } else {
                this.ciz.showToast(str);
            }
        }
    }
}
