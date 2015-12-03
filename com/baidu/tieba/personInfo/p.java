package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.person.ChangePortraitResponse;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends HttpMessageListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(d dVar, int i) {
        super(i);
        this.cSn = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse)) {
            ChangePortraitResponse changePortraitResponse = (ChangePortraitResponse) httpResponsedMessage;
            if (changePortraitResponse.getErrCode() != 0) {
                this.cSn.showToast(changePortraitResponse.getErrorString());
            } else {
                this.cSn.aoK();
            }
        }
    }
}
