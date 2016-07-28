package com.baidu.tieba.person.god;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.god.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ i esQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i, int i2) {
        super(i, i2);
        this.esQ = iVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String ZD;
        i.a aVar;
        i.a aVar2;
        this.esQ.axe = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                ZD = this.esQ.ZD();
                if (!StringUtils.isNull(errorString)) {
                    ZD = errorString;
                }
                aVar = this.esQ.esO;
                if (aVar != null) {
                    aVar2 = this.esQ.esO;
                    aVar2.fD(ZD);
                }
            } else if (responsedMessage instanceof GodThreadListHttpResponseMessage) {
                this.esQ.a(((GodThreadListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GodThreadListSocketResponseMessage) {
                this.esQ.a(((GodThreadListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
