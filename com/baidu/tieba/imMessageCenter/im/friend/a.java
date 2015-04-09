package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity bsu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.bsu = iMBlackListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        i iVar;
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tieba.im.data.a aVar2;
        i iVar2;
        com.baidu.tieba.im.data.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        i iVar3;
        com.baidu.tbadk.core.dialog.a aVar6;
        i iVar4;
        iVar = this.bsu.bss;
        iVar.Vz();
        this.bsu.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar5 = this.bsu.Lt;
                    if (aVar5 != null) {
                        aVar6 = this.bsu.Lt;
                        aVar6.dismiss();
                    }
                    iVar3 = this.bsu.bss;
                    iVar3.B(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.bsu.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.bsu.getResources().getString(com.baidu.tieba.y.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.k.iH()) {
                    iVar4 = this.bsu.bss;
                    iVar4.VA();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.bsu.Lt;
                    if (aVar != null) {
                        aVar4 = this.bsu.Lt;
                        aVar4.dismiss();
                    }
                    this.bsu.showToast(this.bsu.getPageContext().getString(com.baidu.tieba.y.black_list_remove_success));
                    aVar2 = this.bsu.bst;
                    if (aVar2 != null) {
                        iVar2 = this.bsu.bss;
                        aVar3 = this.bsu.bst;
                        iVar2.b(aVar3);
                        this.bsu.bst = null;
                        return;
                    }
                    return;
                }
                this.bsu.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
