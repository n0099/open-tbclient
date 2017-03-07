package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class o implements PraiseModel.a {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void hi(String str) {
        PraiseModel praiseModel;
        PbModel pbModel;
        this.elO.ell = false;
        praiseModel = this.elO.elm;
        if (praiseModel != null) {
            pbModel = this.elO.ejZ;
            com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
            if (pbData.aJq().rG().getIsLike() == 1) {
                this.elO.m18if(0);
            } else {
                this.elO.m18if(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.aJq()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
    public void w(int i, String str) {
        PraiseModel praiseModel;
        this.elO.ell = false;
        praiseModel = this.elO.elm;
        if (praiseModel != null && str != null) {
            if (AntiHelper.rZ(i)) {
                AntiHelper.an(this.elO.getPageContext().getPageActivity(), str);
            } else {
                this.elO.showToast(str);
            }
        }
    }
}
