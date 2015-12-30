package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ f dnJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.dnJ = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
            if (!(httpResponsedMessage.getError() == 0)) {
                Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                if (!(orginalMessage instanceof AdUploadHttpRequest)) {
                    return;
                }
                this.dnJ.bB(((AdUploadHttpRequest) orginalMessage).getDataArray());
            }
        }
    }
}
