package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ f dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.dgY = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterListAdapter imMessageCenterListAdapter2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            imMessageCenterListAdapter = this.dgY.dgP;
            if (imMessageCenterListAdapter != null) {
                imMessageCenterListAdapter2 = this.dgY.dgP;
                imMessageCenterListAdapter2.notifyDataSetChanged();
            }
        }
    }
}
