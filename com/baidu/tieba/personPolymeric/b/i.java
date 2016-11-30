package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ h ePZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i) {
        super(i);
        this.ePZ = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        String errorString;
        TbPageContext tbPageContext5;
        TbPageContext tbPageContext6;
        BlackListModel blackListModel3;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    blackListModel3 = this.ePZ.ePS;
                    blackListModel3.setMaskType(1);
                } else {
                    blackListModel = this.ePZ.ePS;
                    blackListModel.setMaskType(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    blackListModel2 = this.ePZ.ePS;
                    if (blackListModel2.getMaskType() == 1) {
                        tbPageContext3 = this.ePZ.GO;
                        tbPageContext4 = this.ePZ.GO;
                        tbPageContext3.showToast(tbPageContext4.getString(r.j.chat_message_blocked));
                        return;
                    }
                    tbPageContext = this.ePZ.GO;
                    tbPageContext2 = this.ePZ.GO;
                    tbPageContext.showToast(tbPageContext2.getString(r.j.block_chat_remove_success));
                    return;
                }
                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                    tbPageContext6 = this.ePZ.GO;
                    errorString = tbPageContext6.getResources().getString(r.j.neterror);
                } else {
                    errorString = responseUpdateMaskInfoMessage.getErrorString();
                }
                tbPageContext5 = this.ePZ.GO;
                tbPageContext5.showToast(errorString);
            }
        }
    }
}
