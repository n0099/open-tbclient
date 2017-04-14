package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class o implements PraiseModel.a {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hm(String str) {
        PraiseModel praiseModel;
        PbModel pbModel;
        this.ejU.ejr = false;
        praiseModel = this.ejU.ejs;
        if (praiseModel != null) {
            pbModel = this.ejU.eif;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData.aJx().se().getIsLike() == 1) {
                this.ejU.ii(0);
            } else {
                this.ejU.ii(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aJx()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void w(int i, String str) {
        PraiseModel praiseModel;
        this.ejU.ejr = false;
        praiseModel = this.ejU.ejs;
        if (praiseModel != null && str != null) {
            if (AntiHelper.rX(i)) {
                AntiHelper.aq(this.ejU.getPageContext().getPageActivity(), str);
            } else {
                this.ejU.showToast(str);
            }
        }
    }
}
