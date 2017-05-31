package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ fb erO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fc(fb fbVar, int i, int i2) {
        super(i, i2);
        this.erO = fbVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        BdUniqueId bdUniqueId;
        if ((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) {
            z = this.erO.erM;
            if (!z) {
                BdUniqueId tag = responsedMessage.getOrginalMessage().getTag();
                bdUniqueId = this.erO.mTag;
                if (tag == bdUniqueId && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        this.erO.a((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.erO.a((pbPageHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }
}
