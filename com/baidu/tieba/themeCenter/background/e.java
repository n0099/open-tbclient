package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d deM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.deM = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        d.a aVar2;
        com.baidu.tieba.themeCenter.dressCenter.k kVar;
        List<c> list;
        d.a aVar3;
        d.a aVar4;
        com.baidu.tieba.themeCenter.dressCenter.k kVar2;
        List<c> list2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundGroupHttpResponseMessage) || (responsedMessage instanceof BackgroundGroupSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    aVar3 = this.deM.deJ;
                    if (aVar3 != null) {
                        aVar4 = this.deM.deJ;
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        kVar2 = this.deM.mRecommand;
                        list2 = this.deM.deI;
                        aVar4.a(error, errorString, kVar2, list2);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof BackgroundGroupHttpResponseMessage) {
                    BackgroundGroupHttpResponseMessage backgroundGroupHttpResponseMessage = (BackgroundGroupHttpResponseMessage) responsedMessage;
                    this.deM.mRecommand = backgroundGroupHttpResponseMessage.getRecommand();
                    this.deM.deI = backgroundGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BackgroundGroupSocketResponseMessage) {
                    BackgroundGroupSocketResponseMessage backgroundGroupSocketResponseMessage = (BackgroundGroupSocketResponseMessage) responsedMessage;
                    this.deM.mRecommand = backgroundGroupSocketResponseMessage.getRecommand();
                    this.deM.deI = backgroundGroupSocketResponseMessage.getGroupList();
                }
                aVar = this.deM.deJ;
                if (aVar != null) {
                    aVar2 = this.deM.deJ;
                    int error2 = responsedMessage.getError();
                    String errorString2 = responsedMessage.getErrorString();
                    kVar = this.deM.mRecommand;
                    list = this.deM.deI;
                    aVar2.a(error2, errorString2, kVar, list);
                }
            }
        }
    }
}
