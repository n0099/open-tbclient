package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ FloatingPersonalChatActivity buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(FloatingPersonalChatActivity floatingPersonalChatActivity, int i) {
        super(i);
        this.buK = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FloatingPersonalChatView floatingPersonalChatView;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
            floatingPersonalChatView = this.buK.buI;
            floatingPersonalChatView.g(customResponsedMessage);
        }
    }
}
