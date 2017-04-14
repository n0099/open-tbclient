package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ l dkD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l lVar, int i) {
        super(i);
        this.dkD = lVar;
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
                            imMessageCenterModel = this.dkD.dhC;
                            aVar = this.dkD.cQg;
                            imMessageCenterModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            messageAggregationListAdapter3 = this.dkD.dkw;
                            if (messageAggregationListAdapter3 != null) {
                                messageAggregationListAdapter4 = this.dkD.dkw;
                                messageAggregationListAdapter4.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            messageAggregationListAdapter = this.dkD.dkw;
                            if (messageAggregationListAdapter != null) {
                                messageAggregationListAdapter2 = this.dkD.dkw;
                                messageAggregationListAdapter2.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dkD.f(customResponsedMessage);
                    return;
                }
                this.dkD.e(customResponsedMessage);
                return;
            }
            this.dkD.d((CustomResponsedMessage<?>) customResponsedMessage);
        }
    }
}
