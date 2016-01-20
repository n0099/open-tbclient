package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class g implements af.a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void gy(String str) {
        com.baidu.tieba.tbadkCore.af afVar;
        cf cfVar;
        this.cFS.bbT = false;
        afVar = this.cFS.bce;
        if (afVar != null) {
            cfVar = this.cFS.cFl;
            com.baidu.tieba.pb.a.c pbData = cfVar.getPbData();
            if (pbData.akH().getPraise().getIsLike() == 1) {
                this.cFS.fP(0);
            } else {
                this.cFS.fP(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.akH()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void y(int i, String str) {
        com.baidu.tieba.tbadkCore.af afVar;
        this.cFS.bbT = false;
        afVar = this.cFS.bce;
        if (afVar != null && str != null) {
            if (AntiHelper.ne(i)) {
                AntiHelper.Q(this.cFS.getPageContext().getPageActivity(), str);
            } else {
                this.cFS.showToast(str);
            }
        }
    }
}
