package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            FloatingPersonalChatActivityStatic.boZ = null;
        }
    }
}
