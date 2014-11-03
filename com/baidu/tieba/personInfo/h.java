package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* loaded from: classes.dex */
class h extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonInfoActivity bER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bER = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tieba.model.d dVar;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    dVar3 = this.bER.bEF;
                    dVar3.setMaskType(1);
                } else {
                    dVar = this.bER.bEF;
                    dVar.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    dVar2 = this.bER.bEF;
                    if (dVar2.getMaskType() == 1) {
                        this.bER.showToast(this.bER.getString(com.baidu.tieba.y.chat_message_blocked));
                        return;
                    } else {
                        this.bER.showToast(this.bER.getString(com.baidu.tieba.y.block_chat_remove_success));
                        return;
                    }
                }
                this.bER.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
