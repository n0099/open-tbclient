package com.baidu.tieba.person.god;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.god.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ h dxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i, int i2) {
        super(i, i2);
        this.dxa = hVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String aCj;
        h.a aVar;
        h.a aVar2;
        this.dxa.azx = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                aCj = this.dxa.aCj();
                if (!StringUtils.isNull(errorString)) {
                    aCj = errorString;
                }
                aVar = this.dxa.dwY;
                if (aVar != null) {
                    aVar2 = this.dxa.dwY;
                    aVar2.fC(aCj);
                }
            } else if (responsedMessage instanceof GodThreadListHttpResponseMessage) {
                this.dxa.a(((GodThreadListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GodThreadListSocketResponseMessage) {
                this.dxa.a(((GodThreadListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
