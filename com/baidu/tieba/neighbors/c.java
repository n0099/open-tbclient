package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class c extends HttpMessageListener {
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
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        Message<?> orginalMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && orginalMessage.getTag() == this.a.getUniqueId()) {
            TbadkApplication.m252getInst().setLocationShared(true);
        }
    }
}
