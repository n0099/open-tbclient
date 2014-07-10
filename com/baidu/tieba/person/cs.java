package com.baidu.tieba.person;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cs(cr crVar, int i) {
        super(i);
        this.a = crVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tieba.model.c cVar;
        com.baidu.tieba.model.c cVar2;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.c cVar3;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    cVar3 = this.a.f;
                    cVar3.a(1);
                } else {
                    cVar = this.a.f;
                    cVar.a(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    cVar2 = this.a.f;
                    if (cVar2.a() == 1) {
                        cr crVar = this.a;
                        baseFragmentActivity2 = this.a.h;
                        crVar.b(baseFragmentActivity2.getString(com.baidu.tieba.y.black_list_added));
                        return;
                    }
                    cr crVar2 = this.a;
                    baseFragmentActivity = this.a.h;
                    crVar2.b(baseFragmentActivity.getString(com.baidu.tieba.y.black_list_remove_success));
                    return;
                }
                this.a.b(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
