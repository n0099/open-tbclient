package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.bubble.group.d;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dFF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dFF = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        d.a aVar2;
        k kVar;
        List<c> list;
        d.a aVar3;
        d.a aVar4;
        k kVar2;
        List<c> list2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BubbleGroupHttpResponseMessage) || (responsedMessage instanceof BubbleGroupSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    aVar3 = this.dFF.dFE;
                    if (aVar3 != null) {
                        aVar4 = this.dFF.dFE;
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        kVar2 = this.dFF.mRecommand;
                        list2 = this.dFF.dEu;
                        aVar4.a(error, errorString, kVar2, list2);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof BubbleGroupHttpResponseMessage) {
                    BubbleGroupHttpResponseMessage bubbleGroupHttpResponseMessage = (BubbleGroupHttpResponseMessage) responsedMessage;
                    this.dFF.mRecommand = bubbleGroupHttpResponseMessage.getRecommand();
                    this.dFF.dEu = bubbleGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BubbleGroupSocketResponseMessage) {
                    BubbleGroupSocketResponseMessage bubbleGroupSocketResponseMessage = (BubbleGroupSocketResponseMessage) responsedMessage;
                    this.dFF.mRecommand = bubbleGroupSocketResponseMessage.getRecommand();
                    this.dFF.dEu = bubbleGroupSocketResponseMessage.getGroupList();
                }
                aVar = this.dFF.dFE;
                if (aVar != null) {
                    aVar2 = this.dFF.dFE;
                    int error2 = responsedMessage.getError();
                    String errorString2 = responsedMessage.getErrorString();
                    kVar = this.dFF.mRecommand;
                    list = this.dFF.dEu;
                    aVar2.a(error2, errorString2, kVar, list);
                }
            }
        }
    }
}
