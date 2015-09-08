package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.cmR = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        w wVar;
        w wVar2;
        ag agVar;
        w wVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ci) {
                wVar = this.cmR.cmF;
                UserData userData = wVar.getUserData();
                if (userData != null && userData.getHave_attention() != 1) {
                    this.cmR.showToast(i.h.like_success);
                    wVar3 = this.cmR.cmF;
                    wVar3.getUserData().setHave_attention(1);
                } else if (userData != null && userData.getHave_attention() == 1) {
                    wVar2 = this.cmR.cmF;
                    wVar2.getUserData().setHave_attention(2);
                    this.cmR.showToast(i.h.unlike_success);
                }
                agVar = this.cmR.cmG;
                agVar.ahZ();
            } else if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().errorString != null) {
                this.cmR.showToast(updateAttentionMessage.getData().errorString);
            }
        }
    }
}
