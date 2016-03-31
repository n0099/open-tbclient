package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.t;
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
        bf bfVar;
        bf bfVar2;
        bi biVar;
        bi biVar2;
        bf bfVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            bfVar = this.this$0.dvN;
            UserData userData = bfVar.getUserData();
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && userData != null && updateAttentionMessage.getData().toUid.equals(userData.getUserId())) {
                if (updateAttentionMessage.getData().CK) {
                    if (userData.getHave_attention() != 1) {
                        this.this$0.showToast(t.j.like_success);
                        userData.setHave_attention(1);
                        userData.setFansNum(userData.getFansNum() + 1);
                    } else if (userData.getHave_attention() == 1) {
                        userData.setHave_attention(2);
                        userData.setFansNum(Math.max(0, userData.getFansNum() - 1));
                        this.this$0.showToast(t.j.unlike_success);
                    }
                    bfVar2 = this.this$0.dvN;
                    if (bfVar2 != null) {
                        bfVar3 = this.this$0.dvN;
                        bfVar3.aDC();
                    }
                    biVar = this.this$0.dCt;
                    if (biVar != null) {
                        biVar2 = this.this$0.dCt;
                        biVar2.aDM();
                    }
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.this$0.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
