package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i, int i2) {
        super(i, i2);
        this.a = vVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void a(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.b.a aVar;
        int i;
        com.baidu.tieba.b.a aVar2;
        com.baidu.tieba.b.a aVar3;
        int i2;
        com.baidu.tieba.b.a aVar4;
        if ((responsedMessage instanceof ReplyMeSocketResponseMessage) || (responsedMessage instanceof ReplyMeHttpResponseMessage)) {
            if (responsedMessage instanceof ReplyMeSocketResponseMessage) {
                ReplyMeSocketResponseMessage replyMeSocketResponseMessage = (ReplyMeSocketResponseMessage) responsedMessage;
                aVar3 = this.a.o;
                if (aVar3 != null) {
                    long downSize = replyMeSocketResponseMessage.getDownSize();
                    long costTime = replyMeSocketResponseMessage.getCostTime();
                    aVar4 = this.a.o;
                    aVar4.a(false, !responsedMessage.hasError(), replyMeSocketResponseMessage.getError(), replyMeSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.a.o = null;
                }
                if (!replyMeSocketResponseMessage.hasError() && replyMeSocketResponseMessage.getModel() != null) {
                    v vVar = this.a;
                    com.baidu.tieba.model.al model = replyMeSocketResponseMessage.getModel();
                    i2 = this.a.m;
                    vVar.a(model, i2 == 4);
                }
            }
            if (responsedMessage instanceof ReplyMeHttpResponseMessage) {
                ReplyMeHttpResponseMessage replyMeHttpResponseMessage = (ReplyMeHttpResponseMessage) responsedMessage;
                aVar = this.a.o;
                if (aVar != null) {
                    long downSize2 = replyMeHttpResponseMessage.getDownSize();
                    long costTime2 = replyMeHttpResponseMessage.getCostTime();
                    aVar2 = this.a.o;
                    aVar2.a(true, !responsedMessage.hasError(), replyMeHttpResponseMessage.getError(), replyMeHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.a.o = null;
                }
                if (!replyMeHttpResponseMessage.hasError() && replyMeHttpResponseMessage.getModel() != null) {
                    v vVar2 = this.a;
                    com.baidu.tieba.model.al model2 = replyMeHttpResponseMessage.getModel();
                    i = this.a.m;
                    vVar2.a(model2, i == 4);
                }
            }
        }
    }
}
