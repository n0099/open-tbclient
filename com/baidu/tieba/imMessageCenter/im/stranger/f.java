package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ StrangerListActivity chU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(StrangerListActivity strangerListActivity, int i) {
        super(i);
        this.chU = strangerListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        i iVar3;
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            strangerListModel = this.chU.chP;
                            aVar = this.chU.bNs;
                            strangerListModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            iVar = this.chU.chO;
                            if (iVar != null) {
                                iVar2 = this.chU.chO;
                                if (iVar2.aeq() != null) {
                                    iVar3 = this.chU.chO;
                                    iVar3.aeq().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.chU.g(customResponsedMessage);
                    return;
                }
                this.chU.f(customResponsedMessage);
                return;
            }
            this.chU.e(customResponsedMessage);
        }
    }
}
