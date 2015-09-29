package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity cfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.cfa = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.pb.chosen.a.i iVar;
        com.baidu.tieba.pb.chosen.a.i iVar2;
        if (responsedMessage != null) {
            iVar = this.cfa.ceF;
            iVar.aeJ();
            if (responsedMessage.hasError()) {
                BdToast.b(this.cfa.getPageContext().getPageActivity(), StringUtils.isNull(responsedMessage.getErrorString()) ? this.cfa.getResources().getString(i.h.neterror) : responsedMessage.getErrorString()).sZ();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                iVar2 = this.cfa.ceF;
                iVar2.em(((ChosenZanNetMessage) extra).isPraise());
            }
        }
    }
}
