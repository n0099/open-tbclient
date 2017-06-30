package com.baidu.tieba.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.message.CheckRealNameHttpResponseMessage;
import com.baidu.tieba.model.message.CheckRealNameRequestNetMessage;
import com.baidu.tieba.model.message.CheckRealNameSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ CheckRealNameModel ecx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CheckRealNameModel checkRealNameModel, int i, int i2) {
        super(i, i2);
        this.ecx = checkRealNameModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        CheckRealNameModel.a aVar;
        CheckRealNameModel.a aVar2;
        if (responsedMessage != null) {
            if (((responsedMessage instanceof CheckRealNameHttpResponseMessage) || (responsedMessage instanceof CheckRealNameSocketResponseMessage)) && (responsedMessage.getOrginalMessage().getExtra() instanceof CheckRealNameRequestNetMessage)) {
                CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = (CheckRealNameRequestNetMessage) responsedMessage.getOrginalMessage().getExtra();
                aVar = this.ecx.ecv;
                if (aVar != null) {
                    aVar2 = this.ecx.ecv;
                    aVar2.a(responsedMessage.getError(), responsedMessage.getErrorString(), checkRealNameRequestNetMessage.getObjSource(), checkRealNameRequestNetMessage.getObjTag());
                }
            }
        }
    }
}
