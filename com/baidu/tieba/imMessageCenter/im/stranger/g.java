package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ StrangerListActivity btE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(StrangerListActivity strangerListActivity, int i) {
        super(i);
        this.btE = strangerListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        j jVar;
        j jVar2;
        j jVar3;
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            strangerListModel = this.btE.btz;
                            aVar = this.btE.aZD;
                            strangerListModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            jVar = this.btE.bty;
                            if (jVar != null) {
                                jVar2 = this.btE.bty;
                                if (jVar2.VI() != null) {
                                    jVar3 = this.btE.bty;
                                    jVar3.VI().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.btE.e(customResponsedMessage);
                    return;
                }
                this.btE.d(customResponsedMessage);
                return;
            }
            this.btE.c(customResponsedMessage);
        }
    }
}
