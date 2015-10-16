package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.themeCenter.theme.detail.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.dgV = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        d.a aVar;
        d.a aVar2;
        com.baidu.tieba.themeCenter.b bVar;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof SkinDetailHttpResponsedMessage) || (responsedMessage instanceof SkinDetailSocketResponsedMessage)) {
                if (responsedMessage instanceof SkinDetailHttpResponsedMessage) {
                    this.dgV.mSkinData = ((SkinDetailHttpResponsedMessage) responsedMessage).getSkinData();
                } else if (responsedMessage instanceof SkinDetailSocketResponsedMessage) {
                    this.dgV.mSkinData = ((SkinDetailSocketResponsedMessage) responsedMessage).getSkinData();
                }
                aVar = this.dgV.dgU;
                if (aVar != null) {
                    aVar2 = this.dgV.dgU;
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    bVar = this.dgV.mSkinData;
                    aVar2.a(error, errorString, bVar);
                }
            }
        }
    }
}
