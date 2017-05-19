package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.personPolymeric.c.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonPolymericModel eDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPolymericModel personPolymericModel, int i, int i2) {
        super(i, i2);
        this.eDW = personPolymericModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        b bVar;
        n nVar;
        n nVar2;
        boolean z;
        b bVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && this.eDW.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                com.baidu.tieba.person.b bVar3 = responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    bVar3 = (ProfileHttpResponseMessage) responsedMessage;
                }
                if (bVar3.getErrorCode() == 0) {
                    nVar5 = this.eDW.mPersonPolymericData;
                    nVar5.a(bVar3);
                }
                if (responsedMessage.getError() == 0) {
                    nVar = this.eDW.mPersonPolymericData;
                    nVar.aPR();
                    nVar2 = this.eDW.mPersonPolymericData;
                    if (nVar2.ajJ() != null) {
                        nVar4 = this.eDW.mPersonPolymericData;
                        z = nVar4.ajJ().size() >= 20;
                    } else {
                        z = false;
                    }
                    bVar2 = this.eDW.eDT;
                    nVar3 = this.eDW.mPersonPolymericData;
                    bVar2.a(nVar3, z);
                    return;
                }
                bVar = this.eDW.eDT;
                bVar.a(null, true);
            }
        }
    }
}
