package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ StrangerListActivity dyW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(StrangerListActivity strangerListActivity, int i) {
        super(i);
        this.dyW = strangerListActivity;
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
                            strangerListModel = this.dyW.dyR;
                            aVar = this.dyW.ddp;
                            strangerListModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            iVar = this.dyW.dyQ;
                            if (iVar != null) {
                                iVar2 = this.dyW.dyQ;
                                if (iVar2.aBk() != null) {
                                    iVar3 = this.dyW.dyQ;
                                    iVar3.aBk().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dyW.g(customResponsedMessage);
                    return;
                }
                this.dyW.f(customResponsedMessage);
                return;
            }
            this.dyW.e(customResponsedMessage);
        }
    }
}
