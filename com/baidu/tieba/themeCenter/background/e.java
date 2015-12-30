package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dMb = dVar;
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
                    aVar3 = this.dMb.dLZ;
                    if (aVar3 != null) {
                        aVar4 = this.dMb.dLZ;
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        kVar2 = this.dMb.mRecommand;
                        list2 = this.dMb.dLY;
                        aVar4.a(error, errorString, kVar2, list2);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof BackgroundGroupHttpResponseMessage) {
                    BackgroundGroupHttpResponseMessage backgroundGroupHttpResponseMessage = (BackgroundGroupHttpResponseMessage) responsedMessage;
                    this.dMb.mRecommand = backgroundGroupHttpResponseMessage.getRecommand();
                    this.dMb.dLY = backgroundGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BackgroundGroupSocketResponseMessage) {
                    BackgroundGroupSocketResponseMessage backgroundGroupSocketResponseMessage = (BackgroundGroupSocketResponseMessage) responsedMessage;
                    this.dMb.mRecommand = backgroundGroupSocketResponseMessage.getRecommand();
                    this.dMb.dLY = backgroundGroupSocketResponseMessage.getGroupList();
                }
                aVar = this.dMb.dLZ;
                if (aVar != null) {
                    aVar2 = this.dMb.dLZ;
                    int error2 = responsedMessage.getError();
                    String errorString2 = responsedMessage.getErrorString();
                    kVar = this.dMb.mRecommand;
                    list = this.dMb.dLY;
                    aVar2.a(error2, errorString2, kVar, list);
                }
            }
        }
    }
}
