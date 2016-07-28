package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class el extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ek efy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public el(ek ekVar, int i, int i2) {
        super(i, i2);
        this.efy = ekVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        BdUniqueId bdUniqueId;
        if ((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) {
            z = this.efy.efw;
            if (!z) {
                BdUniqueId tag = responsedMessage.getOrginalMessage().getTag();
                bdUniqueId = this.efy.mTag;
                if (tag == bdUniqueId && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        this.efy.a((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.efy.a((pbPageHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }
}
