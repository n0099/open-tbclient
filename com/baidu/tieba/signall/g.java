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
    final /* synthetic */ f cIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.cIT = fVar;
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
                if (error == 110001) {
                    this.cIT.d(httpResponsedMessage);
                }
                String errorString = httpResponsedMessage.getErrorString();
                aVar5 = this.cIT.cIO;
                aVar5.hM(errorString);
            } else if (error == 0) {
                this.cIT.cIN = ((GetForumResponsed) httpResponsedMessage).listData;
                aVar2 = this.cIT.cIO;
                if (aVar2 != null) {
                    cVar = this.cIT.cIN;
                    if (cVar != null) {
                        aVar4 = this.cIT.cIO;
                        cVar2 = this.cIT.cIN;
                        aVar4.a(cVar2);
                    }
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString2)) {
                    errorString2 = TbadkCoreApplication.m411getInst().getContext().getString(i.h.neterror);
                }
                aVar3 = this.cIT.cIO;
                aVar3.hM(errorString2);
            } else {
                String errorString3 = httpResponsedMessage.getErrorString();
                aVar = this.cIT.cIO;
                aVar.hM(errorString3);
            }
            this.cIT.cIP = null;
        }
    }
}
