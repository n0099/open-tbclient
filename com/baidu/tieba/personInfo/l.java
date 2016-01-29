package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(f fVar, int i) {
        super(i);
        this.diG = fVar;
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
            bfVar = this.diG.dbl;
            UserData userData = bfVar.getUserData();
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && userData != null && updateAttentionMessage.getData().toUid.equals(userData.getUserId())) {
                if (updateAttentionMessage.getData().CF) {
                    if (userData.getHave_attention() != 1) {
                        this.diG.showToast(t.j.like_success);
                        userData.setHave_attention(1);
                        userData.setFansNum(userData.getFansNum() + 1);
                    } else if (userData.getHave_attention() == 1) {
                        userData.setHave_attention(2);
                        userData.setFansNum(Math.max(0, userData.getFansNum() - 1));
                        this.diG.showToast(t.j.unlike_success);
                    }
                    bfVar2 = this.diG.dbl;
                    if (bfVar2 != null) {
                        bfVar3 = this.diG.dbl;
                        bfVar3.avX();
                    }
                    biVar = this.diG.dhR;
                    if (biVar != null) {
                        biVar2 = this.diG.dhR;
                        biVar2.awh();
                    }
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.diG.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
