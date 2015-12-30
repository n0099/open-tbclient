package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import com.baidu.tieba.signall.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends HttpMessageListener {
    final /* synthetic */ f dxt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(i);
        this.dxt = fVar;
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
                    this.dxt.d(httpResponsedMessage);
                }
                String errorString = httpResponsedMessage.getErrorString();
                aVar5 = this.dxt.dxn;
                aVar5.iz(errorString);
            } else if (error == 0) {
                this.dxt.dxm = ((GetForumResponsed) httpResponsedMessage).listData;
                aVar2 = this.dxt.dxn;
                if (aVar2 != null) {
                    cVar = this.dxt.dxm;
                    if (cVar != null) {
                        aVar4 = this.dxt.dxn;
                        cVar2 = this.dxt.dxm;
                        aVar4.a(cVar2);
                    }
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString2)) {
                    errorString2 = TbadkCoreApplication.m411getInst().getContext().getString(n.j.neterror);
                }
                aVar3 = this.dxt.dxn;
                aVar3.iz(errorString2);
            } else {
                String errorString3 = httpResponsedMessage.getErrorString();
                aVar = this.dxt.dxn;
                aVar.iz(errorString3);
            }
            this.dxt.dxo = null;
        }
    }
}
