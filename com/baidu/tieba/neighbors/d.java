package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ NeighborsActivity buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(NeighborsActivity neighborsActivity, int i) {
        super(i);
        this.buj = neighborsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponseGetNeighborsMessage responseGetNeighborsMessage;
        Message<?> orginalMessage;
        BdListView bdListView;
        if ((socketResponsedMessage instanceof ResponseGetNeighborsMessage) && (orginalMessage = (responseGetNeighborsMessage = (ResponseGetNeighborsMessage) socketResponsedMessage).getOrginalMessage()) != null && orginalMessage.getTag() == this.buj.getUniqueId()) {
            this.buj.aJQ = false;
            this.buj.closeLoadingDialog();
            bdListView = this.buj.btY;
            bdListView.hN();
            TbadkApplication.m251getInst().getAlarmManager().iP();
            if (!com.baidu.adp.lib.util.m.isNetOk()) {
                this.buj.VR();
            } else {
                this.buj.a(responseGetNeighborsMessage.getNeighborsData());
            }
        }
    }
}
