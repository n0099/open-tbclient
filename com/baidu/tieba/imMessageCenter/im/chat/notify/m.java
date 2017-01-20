package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ f dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(f fVar, int i) {
        super(i);
        this.dgY = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterListAdapter imMessageCenterListAdapter2;
        ImMessageCenterListAdapter imMessageCenterListAdapter3;
        ImMessageCenterListAdapter imMessageCenterListAdapter4;
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.a.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            imMessageCenterModel = this.dgY.dgL;
                            aVar = this.dgY.cPs;
                            imMessageCenterModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            imMessageCenterListAdapter3 = this.dgY.dgP;
                            if (imMessageCenterListAdapter3 != null) {
                                imMessageCenterListAdapter4 = this.dgY.dgP;
                                imMessageCenterListAdapter4.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            imMessageCenterListAdapter = this.dgY.dgP;
                            if (imMessageCenterListAdapter != null) {
                                imMessageCenterListAdapter2 = this.dgY.dgP;
                                imMessageCenterListAdapter2.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dgY.g(customResponsedMessage);
                    return;
                }
                this.dgY.f(customResponsedMessage);
                return;
            }
            this.dgY.e(customResponsedMessage);
        }
    }
}
