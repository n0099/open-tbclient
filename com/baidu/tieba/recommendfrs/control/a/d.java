package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.q;
import com.baidu.tieba.recommendfrs.data.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements q<g, com.baidu.tieba.recommendfrs.data.f> {
    final /* synthetic */ b cbS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cbS = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.r
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.f> mvcHttpResponsedMessage, MvcHttpMessage<g, com.baidu.tieba.recommendfrs.data.f> mvcHttpMessage, MvcNetMessage<g, com.baidu.tieba.recommendfrs.data.f> mvcNetMessage) {
        String str;
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        g gVar;
        if (mvcNetMessage != null) {
            g requestData = mvcNetMessage.getRequestData();
            if (requestData == null) {
                str = null;
            } else {
                str = requestData.ahC();
            }
            if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null) {
                eVar = this.cbS.cbR;
                if (eVar != null) {
                    eVar2 = this.cbS.cbR;
                    eVar2.h(str, mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError());
                    return;
                }
                return;
            }
            com.baidu.tieba.recommendfrs.data.f data = mvcHttpResponsedMessage.getData();
            eVar3 = this.cbS.cbR;
            if (eVar3 != null) {
                eVar4 = this.cbS.cbR;
                gVar = this.cbS.cbQ;
                eVar4.a(true, data, gVar.ahI() != 0, str);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.f, ?> mvcSocketResponsedMessage, MvcSocketMessage<g, com.baidu.tieba.recommendfrs.data.f> mvcSocketMessage, MvcNetMessage<g, com.baidu.tieba.recommendfrs.data.f> mvcNetMessage) {
        String str;
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        g gVar;
        if (mvcNetMessage != null) {
            g requestData = mvcNetMessage.getRequestData();
            if (requestData == null) {
                str = null;
            } else {
                str = requestData.ahC();
            }
            if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null) {
                eVar = this.cbS.cbR;
                if (eVar != null) {
                    eVar2 = this.cbS.cbR;
                    eVar2.h(str, mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError());
                    return;
                }
                return;
            }
            com.baidu.tieba.recommendfrs.data.f data = mvcSocketResponsedMessage.getData();
            eVar3 = this.cbS.cbR;
            if (eVar3 != null) {
                eVar4 = this.cbS.cbR;
                gVar = this.cbS.cbQ;
                eVar4.a(true, data, gVar.ahI() != 0, str);
            }
        }
    }
}
