package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonPolymericModel eML;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPolymericModel personPolymericModel, int i, int i2) {
        super(i, i2);
        this.eML = personPolymericModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        b bVar;
        b bVar2;
        com.baidu.tieba.personPolymeric.c.a aVar;
        b bVar3;
        com.baidu.tieba.personPolymeric.c.a aVar2;
        boolean z = true;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                bdUniqueId = this.eML.unique_id;
                if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                    com.baidu.tieba.person.f fVar = responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        fVar = (ProfileHttpResponseMessage) responsedMessage;
                    }
                    if (fVar.getUserGodInfo() == null || (fVar.getUserGodInfo().god_type.intValue() != 2 && fVar.getUserGodInfo().god_type.intValue() != 1)) {
                        z = false;
                    }
                    if (fVar.getErrorCode() == 0) {
                        bVar3 = this.eML.eMI;
                        bVar3.dk(z);
                        aVar2 = this.eML.eLr;
                        aVar2.a(fVar);
                    }
                    if (responsedMessage.getError() == 0) {
                        bVar2 = this.eML.eMI;
                        aVar = this.eML.eLr;
                        bVar2.a(aVar);
                        return;
                    }
                    bVar = this.eML.eMI;
                    bVar.a(null);
                }
            }
        }
    }
}
