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
        bg bgVar;
        bg bgVar2;
        bj bjVar;
        bj bjVar2;
        bg bgVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            bgVar = this.this$0.dyP;
            UserData userData = bgVar.getUserData();
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && userData != null && updateAttentionMessage.getData().toUid.equals(userData.getUserId())) {
                if (updateAttentionMessage.getData().sZ) {
                    if (userData.getHave_attention() != 1) {
                        this.this$0.showToast(t.j.like_success);
                        userData.setHave_attention(1);
                        userData.setFansNum(userData.getFansNum() + 1);
                    } else if (userData.getHave_attention() == 1) {
                        userData.setHave_attention(2);
                        userData.setFansNum(Math.max(0, userData.getFansNum() - 1));
                        this.this$0.showToast(t.j.unlike_success);
                    }
                    bgVar2 = this.this$0.dyP;
                    if (bgVar2 != null) {
                        bgVar3 = this.this$0.dyP;
                        bgVar3.aEb();
                    }
                    bjVar = this.this$0.dFA;
                    if (bjVar != null) {
                        bjVar2 = this.this$0.dFA;
                        bjVar2.aEm();
                    }
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.this$0.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
