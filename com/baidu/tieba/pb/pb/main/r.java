package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class r implements PraiseModel.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hD(String str) {
        PraiseModel praiseModel;
        PbModel pbModel;
        this.ewh.evC = false;
        praiseModel = this.ewh.evD;
        if (praiseModel != null) {
            pbModel = this.ewh.eue;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData.aMv().rh().getIsLike() == 1) {
                this.ewh.iO(0);
            } else {
                this.ewh.iO(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aMv()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void A(int i, String str) {
        PraiseModel praiseModel;
        this.ewh.evC = false;
        praiseModel = this.ewh.evD;
        if (praiseModel != null && str != null) {
            if (AntiHelper.sK(i)) {
                AntiHelper.ar(this.ewh.getPageContext().getPageActivity(), str);
            } else {
                this.ewh.showToast(str);
            }
        }
    }
}
