package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cyo = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.i iVar;
        com.baidu.tieba.pb.chosen.a.i iVar2;
        String errorString;
        if (responsedMessage != null) {
            iVar = this.cyo.cxR;
            iVar.ajs();
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.cyo.getResources().getString(n.i.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                BdToast.b(this.cyo.getPageContext().getPageActivity(), errorString).tE();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                iVar2 = this.cyo.cxR;
                iVar2.eQ(chosenZanNetMessage.isPraise());
                if (chosenZanNetMessage.isPraise()) {
                    this.cyo.cyd = 1;
                } else {
                    this.cyo.cyd = 0;
                }
            }
        }
    }
}
