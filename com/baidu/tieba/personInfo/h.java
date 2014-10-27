package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* loaded from: classes.dex */
class h extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonInfoActivity bED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bED = personInfoActivity;
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
                    dVar3 = this.bED.bEr;
                    dVar3.setMaskType(1);
                } else {
                    dVar = this.bED.bEr;
                    dVar.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    dVar2 = this.bED.bEr;
                    if (dVar2.getMaskType() == 1) {
                        this.bED.showToast(this.bED.getString(com.baidu.tieba.y.chat_message_blocked));
                        return;
                    } else {
                        this.bED.showToast(this.bED.getString(com.baidu.tieba.y.block_chat_remove_success));
                        return;
                    }
                }
                this.bED.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
