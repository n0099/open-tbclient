package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity bJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.bJa = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.h hVar;
        com.baidu.tieba.pb.chosen.a.h hVar2;
        if (responsedMessage != null) {
            hVar = this.bJa.bIP;
            hVar.aao();
            if (responsedMessage.hasError()) {
                this.bJa.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bJa.getResources().getString(t.neterror) : responsedMessage.getErrorString());
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                hVar2 = this.bJa.bIP;
                hVar2.dN(((ChosenZanNetMessage) extra).isPraise());
            }
        }
    }
}
