package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
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
                    blackListModel3 = this.this$0.dCu;
                    blackListModel3.setMaskType(1);
                } else {
                    blackListModel = this.this$0.dCu;
                    blackListModel.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    blackListModel2 = this.this$0.dCu;
                    if (blackListModel2.getMaskType() == 1) {
                        this.this$0.showToast(this.this$0.getPageContext().getString(t.j.chat_message_blocked));
                        return;
                    } else {
                        this.this$0.showToast(this.this$0.getPageContext().getString(t.j.block_chat_remove_success));
                        return;
                    }
                }
                this.this$0.showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? this.this$0.getResources().getString(t.j.neterror) : responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
