package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class j extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity bGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.bGl = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.e eVar;
        com.baidu.tieba.pb.chosen.a.e eVar2;
        if (responsedMessage != null) {
            eVar = this.bGl.bFX;
            eVar.YQ();
            if (responsedMessage.hasError()) {
                this.bGl.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bGl.getResources().getString(y.neterror) : responsedMessage.getErrorString());
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                eVar2 = this.bGl.bFX;
                eVar2.dB(((ChosenZanNetMessage) extra).isPraise());
            }
        }
    }
}
