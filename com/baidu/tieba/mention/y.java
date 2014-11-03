package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ x bnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, int i, int i2) {
        super(i, i2);
        this.bnY = xVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdListView bdListView;
        BdListView bdListView2;
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
                aVar3 = this.bnY.aAO;
                if (aVar3 != null) {
                    long downSize = replyMeSocketResponseMessage.getDownSize();
                    long costTime = replyMeSocketResponseMessage.getCostTime();
                    aVar4 = this.bnY.aAO;
                    aVar4.a(false, !responsedMessage.hasError(), replyMeSocketResponseMessage.getError(), replyMeSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bnY.aAO = null;
                }
                if (!replyMeSocketResponseMessage.hasError() && replyMeSocketResponseMessage.getModel() != null) {
                    x xVar = this.bnY;
                    com.baidu.tieba.model.am model = replyMeSocketResponseMessage.getModel();
                    i2 = this.bnY.aAo;
                    xVar.a(model, i2 == 4, false);
                } else {
                    this.bnY.dA(false);
                    kVar3 = this.bnY.bnp;
                    kVar3.bO(false);
                    kVar4 = this.bnY.bnp;
                    kVar4.notifyDataSetChanged();
                }
            }
            if (responsedMessage instanceof ReplyMeHttpResponseMessage) {
                ReplyMeHttpResponseMessage replyMeHttpResponseMessage = (ReplyMeHttpResponseMessage) responsedMessage;
                aVar = this.bnY.aAO;
                if (aVar != null) {
                    long downSize2 = replyMeHttpResponseMessage.getDownSize();
                    long costTime2 = replyMeHttpResponseMessage.getCostTime();
                    aVar2 = this.bnY.aAO;
                    aVar2.a(true, !responsedMessage.hasError(), replyMeHttpResponseMessage.getError(), replyMeHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bnY.aAO = null;
                }
                if (!replyMeHttpResponseMessage.hasError() && replyMeHttpResponseMessage.getModel() != null) {
                    x xVar2 = this.bnY;
                    com.baidu.tieba.model.am model2 = replyMeHttpResponseMessage.getModel();
                    i = this.bnY.aAo;
                    xVar2.a(model2, i == 4, false);
                } else {
                    this.bnY.dA(false);
                    kVar = this.bnY.bnp;
                    kVar.bO(false);
                    kVar2 = this.bnY.bnp;
                    kVar2.notifyDataSetChanged();
                }
            }
            bdListView = this.bnY.aoo;
            if (bdListView != null) {
                bdListView2 = this.bnY.aoo;
                bdListView2.hN();
            }
        }
    }
}
