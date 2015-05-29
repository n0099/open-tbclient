package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ d bsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d dVar, int i) {
        super(i);
        this.bsw = dVar;
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
                            imMessageCenterModel = this.bsw.bsj;
                            aVar = this.bsw.bcA;
                            imMessageCenterModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            imMessageCenterListAdapter3 = this.bsw.bsn;
                            if (imMessageCenterListAdapter3 != null) {
                                imMessageCenterListAdapter4 = this.bsw.bsn;
                                imMessageCenterListAdapter4.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            imMessageCenterListAdapter = this.bsw.bsn;
                            if (imMessageCenterListAdapter != null) {
                                imMessageCenterListAdapter2 = this.bsw.bsn;
                                imMessageCenterListAdapter2.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bsw.e(customResponsedMessage);
                    return;
                }
                this.bsw.d(customResponsedMessage);
                return;
            }
            this.bsw.c(customResponsedMessage);
        }
    }
}
