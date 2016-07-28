package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity deK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.deK = iMBlackListActivity;
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
        hVar = this.deK.deI;
        hVar.aty();
        this.deK.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar5 = this.deK.Dq;
                    if (aVar5 != null) {
                        aVar6 = this.deK.Dq;
                        aVar6.dismiss();
                    }
                    hVar3 = this.deK.deI;
                    hVar3.X(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.deK.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.deK.getResources().getString(u.j.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.fq()) {
                    hVar4 = this.deK.deI;
                    hVar4.refreshData();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.deK.Dq;
                    if (aVar != null) {
                        aVar4 = this.deK.Dq;
                        aVar4.dismiss();
                    }
                    this.deK.showToast(this.deK.getPageContext().getString(u.j.black_list_remove_success));
                    aVar2 = this.deK.deJ;
                    if (aVar2 != null) {
                        hVar2 = this.deK.deI;
                        aVar3 = this.deK.deJ;
                        hVar2.b(aVar3);
                        this.deK.deJ = null;
                        return;
                    }
                    return;
                }
                this.deK.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
