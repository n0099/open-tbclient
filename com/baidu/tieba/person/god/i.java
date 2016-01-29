package com.baidu.tieba.person.god;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.god.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ h dcy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i, int i2) {
        super(i, i2);
        this.dcy = hVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String auD;
        h.a aVar;
        h.a aVar2;
        this.dcy.ayQ = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                auD = this.dcy.auD();
                if (!StringUtils.isNull(errorString)) {
                    auD = errorString;
                }
                aVar = this.dcy.dcw;
                if (aVar != null) {
                    aVar2 = this.dcy.dcw;
                    aVar2.fu(auD);
                }
            } else if (responsedMessage instanceof GodThreadListHttpResponseMessage) {
                this.dcy.a(((GodThreadListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GodThreadListSocketResponseMessage) {
                this.dcy.a(((GodThreadListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
