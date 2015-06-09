package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ StrangerListActivity bwE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(StrangerListActivity strangerListActivity, int i) {
        super(i);
        this.bwE = strangerListActivity;
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
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            strangerListModel = this.bwE.bwz;
                            aVar = this.bwE.bcB;
                            strangerListModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            jVar = this.bwE.bwy;
                            if (jVar != null) {
                                jVar2 = this.bwE.bwy;
                                if (jVar2.Xo() != null) {
                                    jVar3 = this.bwE.bwy;
                                    jVar3.Xo().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.bwE.e(customResponsedMessage);
                    return;
                }
                this.bwE.d(customResponsedMessage);
                return;
            }
            this.bwE.c(customResponsedMessage);
        }
    }
}
