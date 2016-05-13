package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.recommendfrs.control.a.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements NetModel.b<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> {
    final /* synthetic */ m dZH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.dZH = mVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.n> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcHttpMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcNetMessage) {
        long a;
        m.a aVar;
        m.a aVar2;
        m.a aVar3;
        com.baidu.tieba.recommendfrs.data.o oVar;
        m.a aVar4;
        m.a aVar5;
        m.a aVar6;
        boolean z = false;
        a = this.dZH.a(mvcNetMessage);
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null || a == -1) {
            aVar = this.dZH.dZD;
            if (aVar != null) {
                aVar2 = this.dZH.dZD;
                aVar2.a(a, mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError());
            }
        } else {
            com.baidu.tieba.recommendfrs.data.n data = mvcHttpResponsedMessage.getData();
            if (data.getThreadList() == null) {
                aVar5 = this.dZH.dZD;
                if (aVar5 != null) {
                    aVar6 = this.dZH.dZD;
                    aVar6.a(a, mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError());
                    return;
                }
            }
            aVar3 = this.dZH.dZD;
            if (aVar3 != null) {
                oVar = this.dZH.dZB;
                boolean z2 = oVar.aMy() != 0;
                if (!(data instanceof com.baidu.tieba.recommendfrs.data.r)) {
                    z = z2;
                } else if (((com.baidu.tieba.recommendfrs.data.r) data).getPn() != 1) {
                    z = true;
                }
                aVar4 = this.dZH.dZD;
                aVar4.a(true, data, z, a);
            }
        }
        this.dZH.a(mvcHttpResponsedMessage, mvcNetMessage);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.n, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcSocketMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n> mvcNetMessage) {
        long a;
        m.a aVar;
        m.a aVar2;
        m.a aVar3;
        com.baidu.tieba.recommendfrs.data.o oVar;
        m.a aVar4;
        m.a aVar5;
        m.a aVar6;
        boolean z = false;
        a = this.dZH.a(mvcNetMessage);
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null || a == -1) {
            aVar = this.dZH.dZD;
            if (aVar != null) {
                aVar2 = this.dZH.dZD;
                aVar2.a(a, mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError());
            }
        } else {
            com.baidu.tieba.recommendfrs.data.n data = mvcSocketResponsedMessage.getData();
            if (data.getThreadList() == null) {
                aVar5 = this.dZH.dZD;
                if (aVar5 != null) {
                    aVar6 = this.dZH.dZD;
                    aVar6.a(a, mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError());
                    return;
                }
            }
            aVar3 = this.dZH.dZD;
            if (aVar3 != null) {
                oVar = this.dZH.dZB;
                boolean z2 = oVar.aMy() != 0;
                if (!(data instanceof com.baidu.tieba.recommendfrs.data.r)) {
                    z = z2;
                } else if (((com.baidu.tieba.recommendfrs.data.r) data).getPn() != 1) {
                    z = true;
                }
                aVar4 = this.dZH.dZD;
                aVar4.a(true, data, z, a);
            }
        }
        this.dZH.a(mvcSocketResponsedMessage, mvcNetMessage);
    }
}
