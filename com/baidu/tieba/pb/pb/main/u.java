package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(PbActivity pbActivity, int i) {
        super(i);
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (!updateAttentionMessage.getData().CB) {
                    if (updateAttentionMessage.getData().errorString != null) {
                        this.ewh.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                this.ewh.b(updateAttentionMessage);
                if (this.ewh.aMC().getAuthor() != null && this.ewh.aMC().getAuthor().getGodUserData() != null) {
                    this.ewh.aMC().getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                }
                this.ewh.c(updateAttentionMessage);
            }
        }
    }
}
