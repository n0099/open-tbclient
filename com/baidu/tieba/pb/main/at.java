package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.frs.dh;
/* loaded from: classes.dex */
class at implements dh {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void fa(String str) {
        df dfVar;
        bn bnVar;
        this.bvu.ayC = false;
        dfVar = this.bvu.ayR;
        if (dfVar != null) {
            bnVar = this.bvu.buU;
            com.baidu.tieba.data.ah pbData = bnVar.getPbData();
            if (pbData.zM().getPraise().getIsLike() == 1) {
                this.bvu.eD(0);
            } else {
                this.bvu.eD(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.zM()));
        }
    }

    @Override // com.baidu.tieba.frs.dh
    public void fb(String str) {
        df dfVar;
        this.bvu.ayC = false;
        dfVar = this.bvu.ayR;
        if (dfVar != null && str != null) {
            this.bvu.showToast(str);
        }
    }
}
