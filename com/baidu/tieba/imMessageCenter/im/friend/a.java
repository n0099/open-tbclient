package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity cct;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.cct = iMBlackListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        h hVar;
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tieba.im.data.a aVar2;
        h hVar2;
        com.baidu.tieba.im.data.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        h hVar3;
        com.baidu.tbadk.core.dialog.a aVar6;
        h hVar4;
        hVar = this.cct.ccr;
        hVar.acE();
        this.cct.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar5 = this.cct.LN;
                    if (aVar5 != null) {
                        aVar6 = this.cct.LN;
                        aVar6.dismiss();
                    }
                    hVar3 = this.cct.ccr;
                    hVar3.L(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.cct.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.cct.getResources().getString(n.i.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.iP()) {
                    hVar4 = this.cct.ccr;
                    hVar4.LV();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.cct.LN;
                    if (aVar != null) {
                        aVar4 = this.cct.LN;
                        aVar4.dismiss();
                    }
                    this.cct.showToast(this.cct.getPageContext().getString(n.i.black_list_remove_success));
                    aVar2 = this.cct.ccs;
                    if (aVar2 != null) {
                        hVar2 = this.cct.ccr;
                        aVar3 = this.cct.ccs;
                        hVar2.b(aVar3);
                        this.cct.ccs = null;
                        return;
                    }
                    return;
                }
                this.cct.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
