package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.theme.detail.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e dOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.dOn = eVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        e.a aVar;
        e.a aVar2;
        com.baidu.tieba.themeCenter.b bVar;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof SkinDetailHttpResponsedMessage) || (responsedMessage instanceof SkinDetailSocketResponsedMessage)) {
                if (responsedMessage instanceof SkinDetailHttpResponsedMessage) {
                    this.dOn.mSkinData = ((SkinDetailHttpResponsedMessage) responsedMessage).getSkinData();
                } else if (responsedMessage instanceof SkinDetailSocketResponsedMessage) {
                    this.dOn.mSkinData = ((SkinDetailSocketResponsedMessage) responsedMessage).getSkinData();
                }
                aVar = this.dOn.dOm;
                if (aVar != null) {
                    aVar2 = this.dOn.dOm;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    bVar = this.dOn.mSkinData;
                    aVar2.a(error, errorString, bVar);
                }
            }
        }
    }
}
