package com.baidu.tieba.recommendfrs.a;

import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements q<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> {
    final /* synthetic */ b bXU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bXU = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.r
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.c> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcNetMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        com.baidu.tieba.recommendfrs.data.d dVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.getError() != 0 || mvcHttpResponsedMessage.getData() == null) {
            eVar = this.bXU.bXT;
            if (eVar != null) {
                eVar2 = this.bXU.bXT;
                eVar2.FV();
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.data.c data = mvcHttpResponsedMessage.getData();
        eVar3 = this.bXU.bXT;
        if (eVar3 != null) {
            eVar4 = this.bXU.bXT;
            dVar = this.bXU.bXS;
            eVar4.a(true, data, dVar.afH() != 0);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcNetMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        com.baidu.tieba.recommendfrs.data.d dVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.getError() != 0 || mvcSocketResponsedMessage.getData() == null) {
            eVar = this.bXU.bXT;
            if (eVar != null) {
                eVar2 = this.bXU.bXT;
                eVar2.FV();
                return;
            }
            return;
        }
        com.baidu.tieba.recommendfrs.data.c data = mvcSocketResponsedMessage.getData();
        eVar3 = this.bXU.bXT;
        if (eVar3 != null) {
            eVar4 = this.bXU.bXT;
            dVar = this.bXU.bXS;
            eVar4.a(true, data, dVar.afH() != 0);
        }
    }
}
