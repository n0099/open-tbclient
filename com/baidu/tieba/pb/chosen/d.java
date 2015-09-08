package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.bZS = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.i iVar;
        com.baidu.tieba.pb.chosen.a.i iVar2;
        if (responsedMessage != null) {
            iVar = this.bZS.bZx;
            iVar.acM();
            if (responsedMessage.hasError()) {
                BdToast.b(this.bZS.getPageContext().getPageActivity(), StringUtils.isNull(responsedMessage.getErrorString()) ? this.bZS.getResources().getString(i.h.neterror) : responsedMessage.getErrorString()).tc();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                iVar2 = this.bZS.bZx;
                iVar2.eh(((ChosenZanNetMessage) extra).isPraise());
            }
        }
    }
}
