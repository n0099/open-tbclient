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
    final /* synthetic */ IMBlackListActivity bMJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.bMJ = iMBlackListActivity;
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
        hVar = this.bMJ.bMH;
        hVar.Zh();
        this.bMJ.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar5 = this.bMJ.Lt;
                    if (aVar5 != null) {
                        aVar6 = this.bMJ.Lt;
                        aVar6.dismiss();
                    }
                    hVar3 = this.bMJ.bMH;
                    hVar3.F(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.bMJ.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.bMJ.getResources().getString(i.h.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.iM()) {
                    hVar4 = this.bMJ.bMH;
                    hVar4.Ko();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.bMJ.Lt;
                    if (aVar != null) {
                        aVar4 = this.bMJ.Lt;
                        aVar4.dismiss();
                    }
                    this.bMJ.showToast(this.bMJ.getPageContext().getString(i.h.black_list_remove_success));
                    aVar2 = this.bMJ.bMI;
                    if (aVar2 != null) {
                        hVar2 = this.bMJ.bMH;
                        aVar3 = this.bMJ.bMI;
                        hVar2.b(aVar3);
                        this.bMJ.bMI = null;
                        return;
                    }
                    return;
                }
                this.bMJ.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
