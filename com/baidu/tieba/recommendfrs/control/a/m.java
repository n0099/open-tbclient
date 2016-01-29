package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.recommendfrs.control.a.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NetModel.b<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> {
    final /* synthetic */ j dEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.dEz = jVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.j> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> mvcHttpMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> mvcNetMessage) {
        long a;
        j.a aVar;
        j.a aVar2;
        j.a aVar3;
        com.baidu.tieba.recommendfrs.data.k kVar;
        j.a aVar4;
        j.a aVar5;
        j.a aVar6;
        boolean z = false;
        a = this.dEz.a(mvcNetMessage);
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null || a == -1) {
            aVar = this.dEz.dEv;
            if (aVar != null) {
                aVar2 = this.dEz.dEv;
                aVar2.a(a, mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError());
            }
        } else {
            com.baidu.tieba.recommendfrs.data.j data = mvcHttpResponsedMessage.getData();
            if (data.getThreadList() == null) {
                aVar5 = this.dEz.dEv;
                if (aVar5 != null) {
                    aVar6 = this.dEz.dEv;
                    aVar6.a(a, mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError());
                    return;
                }
            }
            aVar3 = this.dEz.dEv;
            if (aVar3 != null) {
                kVar = this.dEz.dEt;
                boolean z2 = kVar.aFw() != 0;
                if (!(data instanceof com.baidu.tieba.recommendfrs.data.n)) {
                    z = z2;
                } else if (((com.baidu.tieba.recommendfrs.data.n) data).getPn() != 1) {
                    z = true;
                }
                aVar4 = this.dEz.dEv;
                aVar4.a(true, data, z, a);
            }
        }
        this.dEz.a(mvcHttpResponsedMessage, mvcNetMessage);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> mvcSocketMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.j> mvcNetMessage) {
        long a;
        j.a aVar;
        j.a aVar2;
        j.a aVar3;
        com.baidu.tieba.recommendfrs.data.k kVar;
        j.a aVar4;
        j.a aVar5;
        j.a aVar6;
        boolean z = false;
        a = this.dEz.a(mvcNetMessage);
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null || a == -1) {
            aVar = this.dEz.dEv;
            if (aVar != null) {
                aVar2 = this.dEz.dEv;
                aVar2.a(a, mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError());
            }
        } else {
            com.baidu.tieba.recommendfrs.data.j data = mvcSocketResponsedMessage.getData();
            if (data.getThreadList() == null) {
                aVar5 = this.dEz.dEv;
                if (aVar5 != null) {
                    aVar6 = this.dEz.dEv;
                    aVar6.a(a, mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError());
                    return;
                }
            }
            aVar3 = this.dEz.dEv;
            if (aVar3 != null) {
                kVar = this.dEz.dEt;
                boolean z2 = kVar.aFw() != 0;
                if (!(data instanceof com.baidu.tieba.recommendfrs.data.n)) {
                    z = z2;
                } else if (((com.baidu.tieba.recommendfrs.data.n) data).getPn() != 1) {
                    z = true;
                }
                aVar4 = this.dEz.dEv;
                aVar4.a(true, data, z, a);
            }
        }
        this.dEz.a(mvcSocketResponsedMessage, mvcNetMessage);
    }
}
