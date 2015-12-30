package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cBV = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.i iVar;
        com.baidu.tieba.pb.chosen.a.i iVar2;
        String errorString;
        if (responsedMessage != null) {
            iVar = this.cBV.cBy;
            iVar.akA();
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.cBV.getResources().getString(n.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                BdToast.b(this.cBV.getPageContext().getPageActivity(), errorString).to();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                iVar2 = this.cBV.cBy;
                iVar2.eP(chosenZanNetMessage.isPraise());
                if (chosenZanNetMessage.isPraise()) {
                    this.cBV.cBK = 1;
                } else {
                    this.cBV.cBK = 0;
                }
            }
        }
    }
}
