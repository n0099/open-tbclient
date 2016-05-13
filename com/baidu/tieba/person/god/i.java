package com.baidu.tieba.person.god;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.god.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ h dAg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i, int i2) {
        super(i, i2);
        this.dAg = hVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String aCD;
        h.a aVar;
        h.a aVar2;
        this.dAg.avz = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                aCD = this.dAg.aCD();
                if (!StringUtils.isNull(errorString)) {
                    aCD = errorString;
                }
                aVar = this.dAg.dAe;
                if (aVar != null) {
                    aVar2 = this.dAg.dAe;
                    aVar2.fz(aCD);
                }
            } else if (responsedMessage instanceof GodThreadListHttpResponseMessage) {
                this.dAg.a(((GodThreadListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GodThreadListSocketResponseMessage) {
                this.dAg.a(((GodThreadListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
