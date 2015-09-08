package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.recommendfrs.control.a.b;
import com.baidu.tieba.recommendfrs.data.g;
import com.baidu.tieba.recommendfrs.data.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements NetModel.b<h, g> {
    final /* synthetic */ b cBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cBf = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<g> mvcHttpResponsedMessage, MvcHttpMessage<h, g> mvcHttpMessage, MvcNetMessage<h, g> mvcNetMessage) {
        String str;
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        h hVar;
        if (mvcNetMessage != null) {
            h requestData = mvcNetMessage.getRequestData();
            if (requestData == null) {
                str = null;
            } else {
                str = requestData.anQ();
            }
            if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null) {
                aVar = this.cBf.cBe;
                if (aVar != null) {
                    aVar2 = this.cBf.cBe;
                    aVar2.h(str, mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError());
                    return;
                }
                return;
            }
            g data = mvcHttpResponsedMessage.getData();
            aVar3 = this.cBf.cBe;
            if (aVar3 != null) {
                aVar4 = this.cBf.cBe;
                hVar = this.cBf.cBd;
                aVar4.a(true, data, hVar.anW() != 0, str);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<g, ?> mvcSocketResponsedMessage, MvcSocketMessage<h, g> mvcSocketMessage, MvcNetMessage<h, g> mvcNetMessage) {
        String str;
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        h hVar;
        if (mvcNetMessage != null) {
            h requestData = mvcNetMessage.getRequestData();
            if (requestData == null) {
                str = null;
            } else {
                str = requestData.anQ();
            }
            if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null) {
                aVar = this.cBf.cBe;
                if (aVar != null) {
                    aVar2 = this.cBf.cBe;
                    aVar2.h(str, mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError());
                    return;
                }
                return;
            }
            g data = mvcSocketResponsedMessage.getData();
            aVar3 = this.cBf.cBe;
            if (aVar3 != null) {
                aVar4 = this.cBf.cBe;
                hVar = this.cBf.cBd;
                aVar4.a(true, data, hVar.anW() != 0, str);
            }
        }
    }
}
