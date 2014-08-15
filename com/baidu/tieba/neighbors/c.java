package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(NeighborsActivity neighborsActivity, int i) {
        super(i);
        this.a = neighborsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseGetNeighborsMessage responseGetNeighborsMessage;
        Message<?> orginalMessage;
        l lVar;
        if ((socketResponsedMessage instanceof ResponseGetNeighborsMessage) && (orginalMessage = (responseGetNeighborsMessage = (ResponseGetNeighborsMessage) socketResponsedMessage).getOrginalMessage()) != null && orginalMessage.getTag() == this.a.getUniqueId()) {
            this.a.h = false;
            this.a.closeLoadingDialog();
            lVar = this.a.o;
            lVar.g();
            if (!com.baidu.adp.lib.util.j.c()) {
                this.a.g();
            } else {
                this.a.a(responseGetNeighborsMessage.getNeighborsData());
            }
        }
    }
}
