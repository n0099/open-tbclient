package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ NeighborsActivity btV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(NeighborsActivity neighborsActivity, int i) {
        super(i);
        this.btV = neighborsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null) {
            this.btV.hideProgressBar();
            if (httpResponsedMessage.getError() == 0) {
                this.btV.finish();
                com.baidu.adp.lib.util.m.showToast(this.btV, v.warning_clear_complete);
                return;
            }
            this.btV.showToast(httpResponsedMessage.getErrorString());
        }
    }
}
