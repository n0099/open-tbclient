package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d dVar, int i) {
        super(i);
        this.cSn = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aw awVar;
        aw awVar2;
        az azVar;
        az azVar2;
        aw awVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            awVar = this.cSn.cMT;
            UserData userData = awVar.getUserData();
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && userData != null && updateAttentionMessage.getData().toUid.equals(userData.getUserId())) {
                if (updateAttentionMessage.getData().Cq) {
                    if (userData.getHave_attention() != 1) {
                        this.cSn.showToast(n.i.like_success);
                        awVar3 = this.cSn.cMT;
                        awVar3.getUserData().setHave_attention(1);
                    } else if (userData.getHave_attention() == 1) {
                        awVar2 = this.cSn.cMT;
                        awVar2.getUserData().setHave_attention(2);
                        this.cSn.showToast(n.i.unlike_success);
                    }
                    azVar = this.cSn.cRH;
                    if (azVar != null) {
                        azVar2 = this.cSn.cRH;
                        azVar2.apB();
                    }
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.cSn.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
