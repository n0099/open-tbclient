package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(h hVar, int i) {
        super(i);
        this.this$0 = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bn bnVar;
        bn bnVar2;
        bq bqVar;
        bq bqVar2;
        bn bnVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            bnVar = this.this$0.ers;
            UserData userData = bnVar.getUserData();
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && userData != null && updateAttentionMessage.getData().toUid.equals(userData.getUserId())) {
                if (updateAttentionMessage.getData().tF) {
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
                    bnVar2 = this.this$0.ers;
                    if (bnVar2 != null) {
                        bnVar3 = this.this$0.ers;
                        bnVar3.aPZ();
                    }
                    bqVar = this.this$0.eAu;
                    if (bqVar != null) {
                        bqVar2 = this.this$0.eAu;
                        bqVar2.aQj();
                    }
                    this.this$0.a(updateAttentionMessage);
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.this$0.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
