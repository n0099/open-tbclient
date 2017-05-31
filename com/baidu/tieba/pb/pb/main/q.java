package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class q implements PraiseModel.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hg(String str) {
        PraiseModel praiseModel;
        PbModel pbModel;
        this.enc.emy = false;
        praiseModel = this.enc.emz;
        if (praiseModel != null) {
            pbModel = this.enc.ele;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData.aIB().rk().getIsLike() == 1) {
                this.enc.iC(0);
            } else {
                this.enc.iC(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aIB()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void y(int i, String str) {
        PraiseModel praiseModel;
        this.enc.emy = false;
        praiseModel = this.enc.emz;
        if (praiseModel != null && str != null) {
            if (AntiHelper.sr(i)) {
                AntiHelper.ap(this.enc.getPageContext().getPageActivity(), str);
            } else {
                this.enc.showToast(str);
            }
        }
    }
}
