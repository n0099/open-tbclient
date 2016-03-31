package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class gh extends HttpMessageListener {
    final /* synthetic */ PushThreadActivity dnt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh(PushThreadActivity pushThreadActivity, int i) {
        super(i);
        this.dnt = pushThreadActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
            if (httpResponsedMessage.hasError()) {
                this.dnt.showToast(t.j.neterror);
            } else if (httpResponsedMessage instanceof PbPushHttpResponseMessage) {
                this.dnt.setResult(-1, new Intent());
                this.dnt.finish();
            }
        }
    }
}
