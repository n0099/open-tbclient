package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(d dVar, int i) {
        super(i);
        this.cSn = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        String errorString;
        BlackListModel blackListModel3;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    blackListModel3 = this.cSn.cRI;
                    blackListModel3.setMaskType(1);
                } else {
                    blackListModel = this.cSn.cRI;
                    blackListModel.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    blackListModel2 = this.cSn.cRI;
                    if (blackListModel2.getMaskType() == 1) {
                        this.cSn.showToast(this.cSn.getPageContext().getString(n.i.chat_message_blocked));
                        return;
                    } else {
                        this.cSn.showToast(this.cSn.getPageContext().getString(n.i.block_chat_remove_success));
                        return;
                    }
                }
                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                    errorString = this.cSn.getResources().getString(n.i.neterror);
                } else {
                    errorString = responseUpdateMaskInfoMessage.getErrorString();
                }
                this.cSn.showToast(errorString);
            }
        }
    }
}
