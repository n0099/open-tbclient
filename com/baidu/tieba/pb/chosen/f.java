package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cIA = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.i iVar;
        com.baidu.tieba.pb.chosen.a.i iVar2;
        String errorString;
        if (responsedMessage != null) {
            iVar = this.cIA.cIe;
            iVar.aoy();
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.cIA.getResources().getString(t.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                BdToast.a(this.cIA.getPageContext().getPageActivity(), errorString).us();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                iVar2 = this.cIA.cIe;
                iVar2.fd(chosenZanNetMessage.isPraise());
                if (chosenZanNetMessage.isPraise()) {
                    this.cIA.cIq = 1;
                } else {
                    this.cIA.cIq = 0;
                }
            }
        }
    }
}
