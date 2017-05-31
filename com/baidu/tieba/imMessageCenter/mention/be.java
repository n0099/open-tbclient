package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes2.dex */
class be extends CustomMessageListener {
    final /* synthetic */ ReplyMessageActivity dnl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(ReplyMessageActivity replyMessageActivity, int i) {
        super(i);
        this.dnl = replyMessageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ReplyMeModelController replyMeModelController;
        ReplyMeModelController replyMeModelController2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            replyMeModelController = this.dnl.dnj;
            if (replyMeModelController != null) {
                replyMeModelController2 = this.dnl.dnj;
                replyMeModelController2.VK();
            }
        }
    }
}
