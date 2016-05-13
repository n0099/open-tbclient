package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class m implements af.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void gK(String str) {
        com.baidu.tieba.tbadkCore.af afVar;
        cw cwVar;
        this.djE.beQ = false;
        afVar = this.djE.bfd;
        if (afVar != null) {
            cwVar = this.djE.dih;
            com.baidu.tieba.pb.data.e pbData = cwVar.getPbData();
            if (pbData.avE().getPraise().getIsLike() == 1) {
                this.djE.gg(0);
            } else {
                this.djE.gg(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.avE()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void q(int i, String str) {
        com.baidu.tieba.tbadkCore.af afVar;
        this.djE.beQ = false;
        afVar = this.djE.bfd;
        if (afVar != null && str != null) {
            if (AntiHelper.pv(i)) {
                AntiHelper.O(this.djE.getPageContext().getPageActivity(), str);
            } else {
                this.djE.showToast(str);
            }
        }
    }
}
