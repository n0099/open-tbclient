package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ l duq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.duq = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        MessageAggregationListAdapter messageAggregationListAdapter2;
        MessageAggregationListAdapter messageAggregationListAdapter3;
        MessageAggregationListAdapter messageAggregationListAdapter4;
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.a.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            imMessageCenterModel = this.duq.drm;
                            aVar = this.duq.cZT;
                            imMessageCenterModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            messageAggregationListAdapter3 = this.duq.duj;
                            if (messageAggregationListAdapter3 != null) {
                                messageAggregationListAdapter4 = this.duq.duj;
                                messageAggregationListAdapter4.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            messageAggregationListAdapter = this.duq.duj;
                            if (messageAggregationListAdapter != null) {
                                messageAggregationListAdapter2 = this.duq.duj;
                                messageAggregationListAdapter2.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.duq.f(customResponsedMessage);
                    return;
                }
                this.duq.e(customResponsedMessage);
                return;
            }
            this.duq.d(customResponsedMessage);
        }
    }
}
