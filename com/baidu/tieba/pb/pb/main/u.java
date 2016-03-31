package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class u implements ae.a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void gJ(String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        df dfVar;
        this.dht.biR = false;
        aeVar = this.dht.bjd;
        if (aeVar != null) {
            dfVar = this.dht.dfV;
            com.baidu.tieba.pb.data.e pbData = dfVar.getPbData();
            if (pbData.avv().getPraise().getIsLike() == 1) {
                this.dht.gB(0);
            } else {
                this.dht.gB(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.avv()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void q(int i, String str) {
        com.baidu.tieba.tbadkCore.ae aeVar;
        this.dht.biR = false;
        aeVar = this.dht.bjd;
        if (aeVar != null && str != null) {
            if (AntiHelper.pB(i)) {
                AntiHelper.O(this.dht.getPageContext().getPageActivity(), str);
            } else {
                this.dht.showToast(str);
            }
        }
    }
}
