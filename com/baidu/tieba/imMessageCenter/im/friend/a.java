package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity bJE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.bJE = iMBlackListActivity;
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
        hVar = this.bJE.bJC;
        hVar.Yz();
        this.bJE.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar5 = this.bJE.Lt;
                    if (aVar5 != null) {
                        aVar6 = this.bJE.Lt;
                        aVar6.dismiss();
                    }
                    hVar3 = this.bJE.bJC;
                    hVar3.F(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.bJE.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.bJE.getResources().getString(i.h.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.iL()) {
                    hVar4 = this.bJE.bJC;
                    hVar4.Kt();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.bJE.Lt;
                    if (aVar != null) {
                        aVar4 = this.bJE.Lt;
                        aVar4.dismiss();
                    }
                    this.bJE.showToast(this.bJE.getPageContext().getString(i.h.black_list_remove_success));
                    aVar2 = this.bJE.bJD;
                    if (aVar2 != null) {
                        hVar2 = this.bJE.bJC;
                        aVar3 = this.bJE.bJD;
                        hVar2.b(aVar3);
                        this.bJE.bJD = null;
                        return;
                    }
                    return;
                }
                this.bJE.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
