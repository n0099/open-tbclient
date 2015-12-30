package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.person.SetUserPicsResponse;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends HttpMessageListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(d dVar, int i) {
        super(i);
        this.cWV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
            SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
            if (setUserPicsResponse.getErrCode() != 0) {
                this.cWV.showToast(setUserPicsResponse.getErrorString());
            } else {
                this.cWV.apV();
            }
        }
    }
}
