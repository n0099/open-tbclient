package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class p implements PraiseModel.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hk(String str) {
        PraiseModel praiseModel;
        PbModel pbModel;
        this.ehy.egV = false;
        praiseModel = this.ehy.egW;
        if (praiseModel != null) {
            pbModel = this.ehy.efE;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData.aHG().ro().getIsLike() == 1) {
                this.ehy.ie(0);
            } else {
                this.ehy.ie(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aHG()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void x(int i, String str) {
        PraiseModel praiseModel;
        this.ehy.egV = false;
        praiseModel = this.ehy.egW;
        if (praiseModel != null && str != null) {
            if (AntiHelper.rV(i)) {
                AntiHelper.aq(this.ehy.getPageContext().getPageActivity(), str);
            } else {
                this.ehy.showToast(str);
            }
        }
    }
}
