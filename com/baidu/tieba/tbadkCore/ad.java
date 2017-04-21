package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.PraiseModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends HttpMessageListener {
    final /* synthetic */ PraiseModel fxl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(PraiseModel praiseModel, int i) {
        super(i);
        this.fxl = praiseModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        PraiseModel.a aVar;
        PraiseModel.a aVar2;
        PraiseModel.a aVar3;
        PraiseModel.a aVar4;
        PraiseModel.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                aVar = this.fxl.fxj;
                if (aVar != null) {
                    aVar2 = this.fxl.fxj;
                    aVar2.w(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.fxl.fxj;
                aVar5.hm(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.fxl.fxj;
            if (aVar3 != null) {
                aVar4 = this.fxl.fxj;
                aVar4.w(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
