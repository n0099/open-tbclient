package com.baidu.tieba.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ StrangerListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(StrangerListActivity strangerListActivity, int i) {
        super(i);
        this.a = strangerListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        i iVar3;
        h hVar;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            hVar = this.a.c;
                            aVar = this.a.i;
                            hVar.a((List<ImMessageCenterPojo>) null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            iVar = this.a.b;
                            if (iVar != null) {
                                iVar2 = this.a.b;
                                if (iVar2.a() != null) {
                                    iVar3 = this.a.b;
                                    iVar3.a().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.a.c(customResponsedMessage);
                    return;
                }
                this.a.b(customResponsedMessage);
                return;
            }
            this.a.a(customResponsedMessage);
        }
    }
}
