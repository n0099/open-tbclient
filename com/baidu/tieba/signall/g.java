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
    final /* synthetic */ f cQn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.cQn = fVar;
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
                    this.cQn.d(httpResponsedMessage);
                }
                String errorString = httpResponsedMessage.getErrorString();
                aVar5 = this.cQn.cQi;
                aVar5.hQ(errorString);
            } else if (error == 0) {
                this.cQn.cQh = ((GetForumResponsed) httpResponsedMessage).listData;
                aVar2 = this.cQn.cQi;
                if (aVar2 != null) {
                    cVar = this.cQn.cQh;
                    if (cVar != null) {
                        aVar4 = this.cQn.cQi;
                        cVar2 = this.cQn.cQh;
                        aVar4.a(cVar2);
                    }
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString2)) {
                    errorString2 = TbadkCoreApplication.m411getInst().getContext().getString(i.h.neterror);
                }
                aVar3 = this.cQn.cQi;
                aVar3.hQ(errorString2);
            } else {
                String errorString3 = httpResponsedMessage.getErrorString();
                aVar = this.cQn.cQi;
                aVar.hQ(errorString3);
            }
            this.cQn.cQj = null;
        }
    }
}
