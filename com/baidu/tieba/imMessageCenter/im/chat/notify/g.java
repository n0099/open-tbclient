package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes2.dex */
class g extends CustomMessageListener {
    final /* synthetic */ f dei;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.dei = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterListAdapter imMessageCenterListAdapter2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            imMessageCenterListAdapter = this.dei.ddZ;
            if (imMessageCenterListAdapter != null) {
                imMessageCenterListAdapter2 = this.dei.ddZ;
                imMessageCenterListAdapter2.notifyDataSetChanged();
            }
        }
    }
}
