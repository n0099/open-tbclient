package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbActivity pbActivity, int i) {
        super(i);
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (!updateAttentionMessage.getData().vS) {
                    if (updateAttentionMessage.getData().errorString != null) {
                        this.eah.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                this.eah.b(updateAttentionMessage);
                this.eah.a(updateAttentionMessage);
                this.eah.c(updateAttentionMessage);
            }
        }
    }
}
