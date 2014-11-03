package com.baidu.tieba.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ StrangerListActivity biE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(StrangerListActivity strangerListActivity, int i) {
        super(i);
        this.biE = strangerListActivity;
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
                            strangerListModel = this.biE.biz;
                            aVar = this.biE.aQP;
                            strangerListModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            fVar = this.biE.biy;
                            if (fVar != null) {
                                fVar2 = this.biE.biy;
                                if (fVar2.RH() != null) {
                                    fVar3 = this.biE.biy;
                                    fVar3.RH().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.biE.e(customResponsedMessage);
                    return;
                }
                this.biE.d(customResponsedMessage);
                return;
            }
            this.biE.c(customResponsedMessage);
        }
    }
}
