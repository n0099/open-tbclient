package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import tbclient.Person.DataRes;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(NeighborsActivity neighborsActivity, int i) {
        super(i);
        this.a = neighborsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseGetNeighborsMessage responseGetNeighborsMessage;
        Message<?> orginalMessage;
        BdListView bdListView;
        BdListView bdListView2;
        if ((socketResponsedMessage instanceof ResponseGetNeighborsMessage) && (orginalMessage = (responseGetNeighborsMessage = (ResponseGetNeighborsMessage) socketResponsedMessage).getOrginalMessage()) != null && orginalMessage.getTag() == this.a.getUniqueId()) {
            this.a.i = false;
            this.a.closeLoadingDialog();
            if (!com.baidu.adp.lib.util.j.c()) {
                bdListView = this.a.o;
                bdListView.d();
                this.a.h();
                return;
            }
            DataRes neighborsData = responseGetNeighborsMessage.getNeighborsData();
            bdListView2 = this.a.o;
            bdListView2.d();
            this.a.a(neighborsData);
        }
    }
}
