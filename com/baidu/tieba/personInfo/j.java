package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d dVar, int i) {
        super(i);
        this.cWV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bb bbVar;
        bb bbVar2;
        be beVar;
        be beVar2;
        bb bbVar3;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            bbVar = this.cWV.cRx;
            UserData userData = bbVar.getUserData();
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && userData != null && updateAttentionMessage.getData().toUid.equals(userData.getUserId())) {
                if (updateAttentionMessage.getData().Cv) {
                    if (userData.getHave_attention() != 1) {
                        this.cWV.showToast(n.j.like_success);
                        bbVar3 = this.cWV.cRx;
                        bbVar3.getUserData().setHave_attention(1);
                    } else if (userData.getHave_attention() == 1) {
                        bbVar2 = this.cWV.cRx;
                        bbVar2.getUserData().setHave_attention(2);
                        this.cWV.showToast(n.j.unlike_success);
                    }
                    beVar = this.cWV.cWi;
                    if (beVar != null) {
                        beVar2 = this.cWV.cWi;
                        beVar2.aqQ();
                    }
                } else if (updateAttentionMessage.getData().errorString != null) {
                    this.cWV.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}
