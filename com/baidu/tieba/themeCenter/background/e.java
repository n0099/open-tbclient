package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dfm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dfm = dVar;
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
                    aVar3 = this.dfm.dfj;
                    if (aVar3 != null) {
                        aVar4 = this.dfm.dfj;
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        kVar2 = this.dfm.mRecommand;
                        list2 = this.dfm.dfi;
                        aVar4.a(error, errorString, kVar2, list2);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof BackgroundGroupHttpResponseMessage) {
                    BackgroundGroupHttpResponseMessage backgroundGroupHttpResponseMessage = (BackgroundGroupHttpResponseMessage) responsedMessage;
                    this.dfm.mRecommand = backgroundGroupHttpResponseMessage.getRecommand();
                    this.dfm.dfi = backgroundGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BackgroundGroupSocketResponseMessage) {
                    BackgroundGroupSocketResponseMessage backgroundGroupSocketResponseMessage = (BackgroundGroupSocketResponseMessage) responsedMessage;
                    this.dfm.mRecommand = backgroundGroupSocketResponseMessage.getRecommand();
                    this.dfm.dfi = backgroundGroupSocketResponseMessage.getGroupList();
                }
                aVar = this.dfm.dfj;
                if (aVar != null) {
                    aVar2 = this.dfm.dfj;
                    int error2 = responsedMessage.getError();
                    String errorString2 = responsedMessage.getErrorString();
                    kVar = this.dfm.mRecommand;
                    list = this.dfm.dfi;
                    aVar2.a(error2, errorString2, kVar, list);
                }
            }
        }
    }
}
