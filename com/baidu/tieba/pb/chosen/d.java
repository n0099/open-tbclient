package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.bYY = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.i iVar;
        com.baidu.tieba.pb.chosen.a.i iVar2;
        if (responsedMessage != null) {
            iVar = this.bYY.bYD;
            iVar.acD();
            if (responsedMessage.hasError()) {
                BdToast.b(this.bYY.getPageContext().getPageActivity(), StringUtils.isNull(responsedMessage.getErrorString()) ? this.bYY.getResources().getString(i.C0057i.neterror) : responsedMessage.getErrorString()).sX();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                iVar2 = this.bYY.bYD;
                iVar2.ea(((ChosenZanNetMessage) extra).isPraise());
            }
        }
    }
}
