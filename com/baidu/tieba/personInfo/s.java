package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.csI = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        aj ajVar;
        y yVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Cj) {
                yVar = this.csI.csv;
                UserData userData = yVar.getUserData();
                if (userData != null && userData.getHave_attention() != 1) {
                    this.csI.showToast(i.h.like_success);
                    yVar3 = this.csI.csv;
                    yVar3.getUserData().setHave_attention(1);
                } else if (userData != null && userData.getHave_attention() == 1) {
                    yVar2 = this.csI.csv;
                    yVar2.getUserData().setHave_attention(2);
                    this.csI.showToast(i.h.unlike_success);
                }
                ajVar = this.csI.csw;
                ajVar.ajW();
            } else if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().errorString != null) {
                this.csI.showToast(updateAttentionMessage.getData().errorString);
            }
        }
    }
}
