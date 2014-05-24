package com.baidu.tieba.person;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bm bmVar, int i) {
        super(i);
        this.a = bmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tieba.model.e eVar;
        com.baidu.tieba.model.e eVar2;
        BaseFragmentActivity baseFragmentActivity;
        af afVar;
        com.baidu.tbadk.core.dialog.d dVar;
        com.baidu.tbadk.core.dialog.d dVar2;
        BaseFragmentActivity baseFragmentActivity2;
        af afVar2;
        com.baidu.tieba.model.e eVar3;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                    eVar3 = this.a.d;
                    eVar3.a(1);
                } else {
                    eVar = this.a.d;
                    eVar.a(0);
                }
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    eVar2 = this.a.d;
                    if (eVar2.a() == 1) {
                        bm bmVar = this.a;
                        baseFragmentActivity2 = this.a.f;
                        bmVar.b(baseFragmentActivity2.getString(com.baidu.tieba.y.black_list_added));
                        afVar2 = this.a.n;
                        afVar2.b(true);
                    } else {
                        bm bmVar2 = this.a;
                        baseFragmentActivity = this.a.f;
                        bmVar2.b(baseFragmentActivity.getString(com.baidu.tieba.y.black_list_remove_success));
                        afVar = this.a.n;
                        afVar.b(false);
                    }
                    dVar = this.a.i;
                    if (dVar != null) {
                        dVar2 = this.a.i;
                        dVar2.c();
                        return;
                    }
                    return;
                }
                this.a.b(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
