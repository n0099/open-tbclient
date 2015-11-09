package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.theme.detail.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.diB = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        d.a aVar2;
        com.baidu.tieba.themeCenter.b bVar;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof SkinDetailHttpResponsedMessage) || (responsedMessage instanceof SkinDetailSocketResponsedMessage)) {
                if (responsedMessage instanceof SkinDetailHttpResponsedMessage) {
                    this.diB.mSkinData = ((SkinDetailHttpResponsedMessage) responsedMessage).getSkinData();
                } else if (responsedMessage instanceof SkinDetailSocketResponsedMessage) {
                    this.diB.mSkinData = ((SkinDetailSocketResponsedMessage) responsedMessage).getSkinData();
                }
                aVar = this.diB.diA;
                if (aVar != null) {
                    aVar2 = this.diB.diA;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    bVar = this.diB.mSkinData;
                    aVar2.a(error, errorString, bVar);
                }
            }
        }
    }
}
