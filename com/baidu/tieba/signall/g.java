package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.signall.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ f cAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.cAv = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        f.a aVar;
        f.a aVar2;
        f.a aVar3;
        c cVar;
        f.a aVar4;
        c cVar2;
        f.a aVar5;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
            int error = httpResponsedMessage.getError();
            if (!httpResponsedMessage.isSuccess()) {
                String errorString = httpResponsedMessage.getErrorString();
                aVar5 = this.cAv.cAq;
                aVar5.hD(errorString);
            } else if (error == 0) {
                this.cAv.cAp = ((GetForumResponsed) httpResponsedMessage).listData;
                aVar2 = this.cAv.cAq;
                if (aVar2 != null) {
                    cVar = this.cAv.cAp;
                    if (cVar != null) {
                        aVar4 = this.cAv.cAq;
                        cVar2 = this.cAv.cAp;
                        aVar4.a(cVar2);
                    }
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString2)) {
                    errorString2 = TbadkCoreApplication.m411getInst().getContext().getString(i.C0057i.neterror);
                }
                aVar3 = this.cAv.cAq;
                aVar3.hD(errorString2);
            } else {
                String errorString3 = httpResponsedMessage.getErrorString();
                aVar = this.cAv.cAq;
                aVar.hD(errorString3);
            }
            this.cAv.cAr = null;
        }
    }
}
