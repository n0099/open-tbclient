package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ NeighborsActivity buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(NeighborsActivity neighborsActivity, int i) {
        super(i);
        this.buj = neighborsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null) {
            this.buj.hideProgressBar();
            if (httpResponsedMessage.getError() == 0) {
                this.buj.finish();
                com.baidu.adp.lib.util.m.showToast(this.buj, v.warning_clear_complete);
                return;
            }
            this.buj.showToast(httpResponsedMessage.getErrorString());
        }
    }
}
