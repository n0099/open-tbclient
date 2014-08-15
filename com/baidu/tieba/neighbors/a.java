package com.baidu.tieba.neighbors;

import android.content.Context;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(NeighborsActivity neighborsActivity, int i) {
        super(i);
        this.a = neighborsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null) {
            this.a.hideProgressBar();
            if (httpResponsedMessage.getError() == 0) {
                this.a.finish();
                com.baidu.adp.lib.util.j.a((Context) this.a, x.warning_clear_complete);
                return;
            }
            this.a.showToast(httpResponsedMessage.getErrorString());
        }
    }
}
