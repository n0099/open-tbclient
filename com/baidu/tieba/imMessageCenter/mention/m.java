package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ l duq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, int i) {
        super(i);
        this.duq = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        MessageAggregationListAdapter messageAggregationListAdapter2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            messageAggregationListAdapter = this.duq.duj;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter2 = this.duq.duj;
                messageAggregationListAdapter2.notifyDataSetChanged();
            }
        }
    }
}
