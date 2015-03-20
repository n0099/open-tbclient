package com.baidu.tieba.imMessageCenter.im.floatwindow;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ b bqs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar) {
        super(2008015);
        this.bqs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008015) {
            this.bqs.dk(true);
        }
    }
}
