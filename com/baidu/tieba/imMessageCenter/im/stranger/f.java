package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes2.dex */
class f extends CustomMessageListener {
    final /* synthetic */ StrangerListActivity dtI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(StrangerListActivity strangerListActivity, int i) {
        super(i);
        this.dtI = strangerListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        i iVar3;
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.a.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            strangerListModel = this.dtI.dtD;
                            aVar = this.dtI.cZT;
                            strangerListModel.setData(null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            iVar = this.dtI.dtC;
                            if (iVar != null) {
                                iVar2 = this.dtI.dtC;
                                if (iVar2.axA() != null) {
                                    iVar3 = this.dtI.dtC;
                                    iVar3.axA().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.dtI.f(customResponsedMessage);
                    return;
                }
                this.dtI.e(customResponsedMessage);
                return;
            }
            this.dtI.d(customResponsedMessage);
        }
    }
}
