package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class o implements PraiseModel.a {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hm(String str) {
        PraiseModel praiseModel;
        PbModel pbModel;
        this.emk.elH = false;
        praiseModel = this.emk.elI;
        if (praiseModel != null) {
            pbModel = this.emk.ekv;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData.aKy().se().getIsLike() == 1) {
                this.emk.io(0);
            } else {
                this.emk.io(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aKy()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void w(int i, String str) {
        PraiseModel praiseModel;
        this.emk.elH = false;
        praiseModel = this.emk.elI;
        if (praiseModel != null && str != null) {
            if (AntiHelper.sd(i)) {
                AntiHelper.aq(this.emk.getPageContext().getPageActivity(), str);
            } else {
                this.emk.showToast(str);
            }
        }
    }
}
