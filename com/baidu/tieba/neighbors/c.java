package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
    final /* synthetic */ NeighborsActivity buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(NeighborsActivity neighborsActivity, int i) {
        super(i);
        this.buj = neighborsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        Message<?> orginalMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && orginalMessage.getTag() == this.buj.getUniqueId()) {
            TbadkApplication.m251getInst().setLocationShared(true);
        }
    }
}
