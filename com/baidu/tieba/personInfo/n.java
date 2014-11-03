package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity bER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bER = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        v vVar2;
        ae aeVar;
        v vVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ln) {
                vVar = this.bER.bEG;
                UserData userData = vVar.getUserData();
                if (userData != null && userData.getHave_attention() != 1) {
                    this.bER.showToast(com.baidu.tieba.y.like_success);
                    vVar3 = this.bER.bEG;
                    vVar3.getUserData().setHave_attention(1);
                } else if (userData != null && userData.getHave_attention() == 1) {
                    vVar2 = this.bER.bEG;
                    vVar2.getUserData().setHave_attention(2);
                    this.bER.showToast(com.baidu.tieba.y.unlike_success);
                }
                aeVar = this.bER.bEH;
                aeVar.abh();
            } else if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().errorString != null) {
                this.bER.showToast(updateAttentionMessage.getData().errorString);
            }
        }
    }
}
