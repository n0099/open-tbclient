package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.person.ChangePortraitResponse;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends HttpMessageListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(h hVar, int i) {
        super(i);
        this.this$0 = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ChangePortraitResponse) || ((ChangePortraitResponse) httpResponsedMessage).getErrCode() != 0) {
            return;
        }
        this.this$0.aPn();
    }
}
