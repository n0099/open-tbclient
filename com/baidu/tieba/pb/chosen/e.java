package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cfM = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.i iVar;
        com.baidu.tieba.pb.chosen.a.i iVar2;
        if (responsedMessage != null) {
            iVar = this.cfM.cfr;
            iVar.afa();
            if (responsedMessage.hasError()) {
                BdToast.b(this.cfM.getPageContext().getPageActivity(), StringUtils.isNull(responsedMessage.getErrorString()) ? this.cfM.getResources().getString(i.h.neterror) : responsedMessage.getErrorString()).sZ();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                iVar2 = this.cfM.cfr;
                iVar2.eo(((ChosenZanNetMessage) extra).isPraise());
            }
        }
    }
}
