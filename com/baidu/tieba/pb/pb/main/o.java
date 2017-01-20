package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class o implements PraiseModel.a {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void ht(String str) {
        PraiseModel praiseModel;
        PbModel pbModel;
        this.eiV.eis = false;
        praiseModel = this.eiV.eit;
        if (praiseModel != null) {
            pbModel = this.eiV.ehh;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData.aJZ().rn().getIsLike() == 1) {
                this.eiV.ij(0);
            } else {
                this.eiV.ij(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aJZ()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void v(int i, String str) {
        PraiseModel praiseModel;
        this.eiV.eis = false;
        praiseModel = this.eiV.eit;
        if (praiseModel != null && str != null) {
            if (AntiHelper.sa(i)) {
                AntiHelper.T(this.eiV.getPageContext().getPageActivity(), str);
            } else {
                this.eiV.showToast(str);
            }
        }
    }
}
