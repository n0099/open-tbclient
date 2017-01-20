package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bd extends CustomMessageListener {
    final /* synthetic */ ReplyMessageActivity dkB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(ReplyMessageActivity replyMessageActivity, int i) {
        super(i);
        this.dkB = replyMessageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ReplyMeModelController replyMeModelController;
        ReplyMeModelController replyMeModelController2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            replyMeModelController = this.dkB.dkz;
            if (replyMeModelController != null) {
                replyMeModelController2 = this.dkB.dkz;
                replyMeModelController2.lN();
            }
        }
    }
}
