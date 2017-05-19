package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.PraiseModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends HttpMessageListener {
    final /* synthetic */ PraiseModel ftp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(PraiseModel praiseModel, int i) {
        super(i);
        this.ftp = praiseModel;
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
                aVar = this.ftp.fto;
                if (aVar != null) {
                    aVar2 = this.ftp.fto;
                    aVar2.x(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                aVar5 = this.ftp.fto;
                aVar5.hk(praiseResponseMessage.getErrMsg());
                return;
            }
            aVar3 = this.ftp.fto;
            if (aVar3 != null) {
                aVar4 = this.ftp.fto;
                aVar4.x(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }
}
