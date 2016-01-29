package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ dq cQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr(dq dqVar, int i, int i2) {
        super(i, i2);
        this.cQa = dqVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        BdUniqueId bdUniqueId;
        if ((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) {
            z = this.cQa.cPY;
            if (!z) {
                BdUniqueId tag = responsedMessage.getOrginalMessage().getTag();
                bdUniqueId = this.cQa.mTag;
                if (tag == bdUniqueId && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        this.cQa.a((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.cQa.a((pbPageHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }
}
