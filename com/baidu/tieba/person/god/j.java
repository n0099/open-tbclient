package com.baidu.tieba.person.god;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.person.god.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ i eiM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i, int i2) {
        super(i, i2);
        this.eiM = iVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String Zh;
        i.a aVar;
        i.a aVar2;
        this.eiM.awp = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                Zh = this.eiM.Zh();
                if (!StringUtils.isNull(errorString)) {
                    Zh = errorString;
                }
                aVar = this.eiM.eiK;
                if (aVar != null) {
                    aVar2 = this.eiM.eiK;
                    aVar2.fF(Zh);
                }
            } else if (responsedMessage instanceof GodThreadListHttpResponseMessage) {
                this.eiM.a(((GodThreadListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GodThreadListSocketResponseMessage) {
                this.eiM.a(((GodThreadListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
