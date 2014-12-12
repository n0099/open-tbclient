package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
/* loaded from: classes.dex */
class h extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonInfoActivity bIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bIm = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    blackListModel3 = this.bIm.bIa;
                    blackListModel3.setMaskType(1);
                } else {
                    blackListModel = this.bIm.bIa;
                    blackListModel.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    blackListModel2 = this.bIm.bIa;
                    if (blackListModel2.getMaskType() == 1) {
                        this.bIm.showToast(this.bIm.getPageContext().getString(com.baidu.tieba.z.chat_message_blocked));
                        return;
                    } else {
                        this.bIm.showToast(this.bIm.getPageContext().getString(com.baidu.tieba.z.block_chat_remove_success));
                        return;
                    }
                }
                this.bIm.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
