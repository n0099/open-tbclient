package com.baidu.tieba.person;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(ct ctVar, int i) {
        super(i);
        this.a = ctVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tieba.model.d dVar;
        com.baidu.tieba.model.d dVar2;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.d dVar3;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    dVar3 = this.a.f;
                    dVar3.a(1);
                } else {
                    dVar = this.a.f;
                    dVar.a(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    dVar2 = this.a.f;
                    if (dVar2.a() == 1) {
                        ct ctVar = this.a;
                        baseFragmentActivity2 = this.a.h;
                        ctVar.b(baseFragmentActivity2.getString(com.baidu.tieba.x.chat_message_blocked));
                        return;
                    }
                    ct ctVar2 = this.a;
                    baseFragmentActivity = this.a.h;
                    ctVar2.b(baseFragmentActivity.getString(com.baidu.tieba.x.block_chat_remove_success));
                    return;
                }
                this.a.b(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
