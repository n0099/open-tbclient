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
public class m implements NetModel.b<com.baidu.tieba.recommendfrs.data.i, com.baidu.tieba.recommendfrs.data.h> {
    final /* synthetic */ j dpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.dpb = jVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.h> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.recommendfrs.data.i, com.baidu.tieba.recommendfrs.data.h> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.recommendfrs.data.i, com.baidu.tieba.recommendfrs.data.h> mvcNetMessage) {
        long a;
        j.a aVar;
        j.a aVar2;
        j.a aVar3;
        j.a aVar4;
        com.baidu.tieba.recommendfrs.data.i iVar;
        a = this.dpb.a(mvcNetMessage);
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null || a == -1) {
            aVar = this.dpb.doZ;
            if (aVar != null) {
                aVar2 = this.dpb.doZ;
                aVar2.a(a, mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError());
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.data.h data = mvcHttpResponsedMessage.getData();
        aVar3 = this.dpb.doZ;
        if (aVar3 != null) {
            aVar4 = this.dpb.doZ;
            iVar = this.dpb.doY;
            aVar4.a(true, data, iVar.ayr() != 0, a);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.h, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.recommendfrs.data.i, com.baidu.tieba.recommendfrs.data.h> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.recommendfrs.data.i, com.baidu.tieba.recommendfrs.data.h> mvcNetMessage) {
        long a;
        j.a aVar;
        j.a aVar2;
        j.a aVar3;
        j.a aVar4;
        com.baidu.tieba.recommendfrs.data.i iVar;
        a = this.dpb.a(mvcNetMessage);
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null || a == -1) {
            aVar = this.dpb.doZ;
            if (aVar != null) {
                aVar2 = this.dpb.doZ;
                aVar2.a(a, mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError());
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.data.h data = mvcSocketResponsedMessage.getData();
        aVar3 = this.dpb.doZ;
        if (aVar3 != null) {
            aVar4 = this.dpb.doZ;
            iVar = this.dpb.doY;
            aVar4.a(true, data, iVar.ayr() != 0, a);
        }
    }
}
