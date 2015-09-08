package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ e bGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(e eVar, int i) {
        super(i);
        this.bGV = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterListAdapter imMessageCenterListAdapter2;
        ImMessageCenterListAdapter imMessageCenterListAdapter3;
        ImMessageCenterListAdapter imMessageCenterListAdapter4;
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            imMessageCenterModel = this.bGV.bGI;
                            aVar = this.bGV.bqT;
                            imMessageCenterModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            imMessageCenterListAdapter3 = this.bGV.bGM;
                            if (imMessageCenterListAdapter3 != null) {
                                imMessageCenterListAdapter4 = this.bGV.bGM;
                                imMessageCenterListAdapter4.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            imMessageCenterListAdapter = this.bGV.bGM;
                            if (imMessageCenterListAdapter != null) {
                                imMessageCenterListAdapter2 = this.bGV.bGM;
                                imMessageCenterListAdapter2.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bGV.g(customResponsedMessage);
                    return;
                }
                this.bGV.f(customResponsedMessage);
                return;
            }
            this.bGV.e(customResponsedMessage);
        }
    }
}
