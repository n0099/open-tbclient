package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.SetUserPicsResponse;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends HttpMessageListener {
    final /* synthetic */ y eLx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(y yVar, int i) {
        super(i);
        this.eLx = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        TbPageContext tbPageContext;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
            SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
            if (setUserPicsResponse.getErrCode() != 0) {
                tbPageContext = this.eLx.ajh;
                tbPageContext.showToast(setUserPicsResponse.getErrorString());
                this.eLx.jv(false);
                return;
            }
            this.eLx.aRh();
        }
    }
}
