package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ x bnK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, int i, int i2) {
        super(i, i2);
        this.bnK = xVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.b.a aVar;
        k kVar;
        k kVar2;
        int i;
        com.baidu.tieba.b.a aVar2;
        com.baidu.tieba.b.a aVar3;
        k kVar3;
        k kVar4;
        int i2;
        com.baidu.tieba.b.a aVar4;
        if ((responsedMessage instanceof ReplyMeSocketResponseMessage) || (responsedMessage instanceof ReplyMeHttpResponseMessage)) {
            if (responsedMessage instanceof ReplyMeSocketResponseMessage) {
                ReplyMeSocketResponseMessage replyMeSocketResponseMessage = (ReplyMeSocketResponseMessage) responsedMessage;
                aVar3 = this.bnK.aAE;
                if (aVar3 != null) {
                    long downSize = replyMeSocketResponseMessage.getDownSize();
                    long costTime = replyMeSocketResponseMessage.getCostTime();
                    aVar4 = this.bnK.aAE;
                    aVar4.a(false, !responsedMessage.hasError(), replyMeSocketResponseMessage.getError(), replyMeSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bnK.aAE = null;
                }
                if (!replyMeSocketResponseMessage.hasError() && replyMeSocketResponseMessage.getModel() != null) {
                    x xVar = this.bnK;
                    com.baidu.tieba.model.am model = replyMeSocketResponseMessage.getModel();
                    i2 = this.bnK.aAf;
                    xVar.a(model, i2 == 4, false);
                } else {
                    this.bnK.dA(false);
                    kVar3 = this.bnK.bnb;
                    kVar3.bO(false);
                    kVar4 = this.bnK.bnb;
                    kVar4.notifyDataSetChanged();
                }
            }
            if (responsedMessage instanceof ReplyMeHttpResponseMessage) {
                ReplyMeHttpResponseMessage replyMeHttpResponseMessage = (ReplyMeHttpResponseMessage) responsedMessage;
                aVar = this.bnK.aAE;
                if (aVar != null) {
                    long downSize2 = replyMeHttpResponseMessage.getDownSize();
                    long costTime2 = replyMeHttpResponseMessage.getCostTime();
                    aVar2 = this.bnK.aAE;
                    aVar2.a(true, !responsedMessage.hasError(), replyMeHttpResponseMessage.getError(), replyMeHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bnK.aAE = null;
                }
                if (!replyMeHttpResponseMessage.hasError() && replyMeHttpResponseMessage.getModel() != null) {
                    x xVar2 = this.bnK;
                    com.baidu.tieba.model.am model2 = replyMeHttpResponseMessage.getModel();
                    i = this.bnK.aAf;
                    xVar2.a(model2, i == 4, false);
                    return;
                }
                this.bnK.dA(false);
                kVar = this.bnK.bnb;
                kVar.bO(false);
                kVar2 = this.bnK.bnb;
                kVar2.notifyDataSetChanged();
            }
        }
    }
}
