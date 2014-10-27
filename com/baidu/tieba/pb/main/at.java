package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.frs.dh;
/* loaded from: classes.dex */
class at implements dh {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void fa(String str) {
        df dfVar;
        bn bnVar;
        this.bvg.ayt = false;
        dfVar = this.bvg.ayI;
        if (dfVar != null) {
            bnVar = this.bvg.buG;
            com.baidu.tieba.data.ah pbData = bnVar.getPbData();
            if (pbData.zK().getPraise().getIsLike() == 1) {
                this.bvg.eD(0);
            } else {
                this.bvg.eD(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.zK()));
        }
    }

    @Override // com.baidu.tieba.frs.dh
    public void fb(String str) {
        df dfVar;
        this.bvg.ayt = false;
        dfVar = this.bvg.ayI;
        if (dfVar != null && str != null) {
            this.bvg.showToast(str);
        }
    }
}
