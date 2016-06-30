package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ FloatingPersonalChatActivity dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(FloatingPersonalChatActivity floatingPersonalChatActivity, int i) {
        super(i);
        this.dbp = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FloatingPersonalChatView floatingPersonalChatView;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
            floatingPersonalChatView = this.dbp.dbn;
            floatingPersonalChatView.i(customResponsedMessage);
        }
    }
}
