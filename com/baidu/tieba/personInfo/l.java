package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bp bpVar;
        bp bpVar2;
        bs bsVar;
        bs bsVar2;
        bp bpVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            bpVar = this.this$0.eht;
            UserData userData = bpVar.getUserData();
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && userData != null && updateAttentionMessage.getData().toUid.equals(userData.getUserId())) {
                if (updateAttentionMessage.getData().tb) {
                    if (userData.getHave_attention() != 1) {
                        if (!updateAttentionMessage.isGod()) {
                            this.this$0.showToast(u.j.like_success);
                        }
                        userData.setHave_attention(1);
                        userData.setFansNum(userData.getFansNum() + 1);
                    } else if (userData.getHave_attention() == 1) {
                        userData.setHave_attention(2);
                        userData.setFansNum(Math.max(0, userData.getFansNum() - 1));
                        this.this$0.showToast(u.j.unlike_success);
                    }
                    bpVar2 = this.this$0.eht;
                    if (bpVar2 != null) {
                        bpVar3 = this.this$0.eht;
                        bpVar3.aMW();
                    }
                    bsVar = this.this$0.eoE;
                    if (bsVar != null) {
                        bsVar2 = this.this$0.eoE;
                        bsVar2.aNg();
                    }
                    this.this$0.a(updateAttentionMessage);
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.this$0.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
