package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.recommendfrs.control.a.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements NetModel.b<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> {
    final /* synthetic */ b diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.diG = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.c> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcNetMessage) {
        long a;
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        com.baidu.tieba.recommendfrs.data.d dVar;
        a = this.diG.a(mvcNetMessage);
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null || a == -1) {
            aVar = this.diG.diF;
            if (aVar != null) {
                aVar2 = this.diG.diF;
                aVar2.a(a, mvcHttpResponsedMessage.getErrorString(), mvcHttpResponsedMessage.getError());
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.data.c data = mvcHttpResponsedMessage.getData();
        aVar3 = this.diG.diF;
        if (aVar3 != null) {
            aVar4 = this.diG.diF;
            dVar = this.diG.diE;
            aVar4.a(true, data, dVar.awn() != 0, a);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcNetMessage) {
        long a;
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        com.baidu.tieba.recommendfrs.data.d dVar;
        a = this.diG.a(mvcNetMessage);
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null || a == -1) {
            aVar = this.diG.diF;
            if (aVar != null) {
                aVar2 = this.diG.diF;
                aVar2.a(a, mvcSocketResponsedMessage.getErrorString(), mvcSocketResponsedMessage.getError());
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.data.c data = mvcSocketResponsedMessage.getData();
        aVar3 = this.diG.diF;
        if (aVar3 != null) {
            aVar4 = this.diG.diF;
            dVar = this.diG.diE;
            aVar4.a(true, data, dVar.awn() != 0, a);
        }
    }
}
