package com.baidu.tieba.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ StrangerListActivity bnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(StrangerListActivity strangerListActivity, int i) {
        super(i);
        this.bnU = strangerListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        f fVar;
        f fVar2;
        f fVar3;
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            strangerListModel = this.bnU.bnP;
                            aVar = this.bnU.aSt;
                            strangerListModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            fVar = this.bnU.bnO;
                            if (fVar != null) {
                                fVar2 = this.bnU.bnO;
                                if (fVar2.Tb() != null) {
                                    fVar3 = this.bnU.bnO;
                                    fVar3.Tb().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bnU.e(customResponsedMessage);
                    return;
                }
                this.bnU.d(customResponsedMessage);
                return;
            }
            this.bnU.c(customResponsedMessage);
        }
    }
}
