package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ f dhP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(f fVar, int i) {
        super(i);
        this.dhP = fVar;
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
                            imMessageCenterModel = this.dhP.dhC;
                            aVar = this.dhP.cQg;
                            imMessageCenterModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            imMessageCenterListAdapter3 = this.dhP.dhG;
                            if (imMessageCenterListAdapter3 != null) {
                                imMessageCenterListAdapter4 = this.dhP.dhG;
                                imMessageCenterListAdapter4.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            imMessageCenterListAdapter = this.dhP.dhG;
                            if (imMessageCenterListAdapter != null) {
                                imMessageCenterListAdapter2 = this.dhP.dhG;
                                imMessageCenterListAdapter2.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dhP.f(customResponsedMessage);
                    return;
                }
                this.dhP.e(customResponsedMessage);
                return;
            }
            this.dhP.d(customResponsedMessage);
        }
    }
}
