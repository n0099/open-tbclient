package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ f cec;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.cec = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        h hVar;
        h hVar2;
        h hVar3;
        c cVar;
        h hVar4;
        c cVar2;
        h hVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
            int error = httpResponsedMessage.getError();
            if (!httpResponsedMessage.isSuccess()) {
                String errorString = httpResponsedMessage.getErrorString();
                hVar5 = this.cec.cdX;
                hVar5.gB(errorString);
            } else if (error == 0) {
                this.cec.cdW = ((GetForumResponsed) httpResponsedMessage).listData;
                hVar2 = this.cec.cdX;
                if (hVar2 != null) {
                    cVar = this.cec.cdW;
                    if (cVar != null) {
                        hVar4 = this.cec.cdX;
                        cVar2 = this.cec.cdW;
                        hVar4.a(cVar2);
                    }
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString2)) {
                    errorString2 = TbadkCoreApplication.m411getInst().getContext().getString(com.baidu.tieba.y.neterror);
                }
                hVar3 = this.cec.cdX;
                hVar3.gB(errorString2);
            } else {
                String errorString3 = httpResponsedMessage.getErrorString();
                hVar = this.cec.cdX;
                hVar.gB(errorString3);
            }
            this.cec.cdY = null;
        }
    }
}
