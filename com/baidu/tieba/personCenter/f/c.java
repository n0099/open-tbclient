package com.baidu.tieba.personCenter.f;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b epI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.epI = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        a aVar;
        com.baidu.tieba.personCenter.c.a aVar2 = null;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && this.epI.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                com.baidu.tieba.person.b bVar = responsedMessage instanceof ProfileHttpResponseMessage ? (ProfileHttpResponseMessage) responsedMessage : responsedMessage instanceof ProfileSocketResponseMessage ? (ProfileSocketResponseMessage) responsedMessage : null;
                if (bVar.getErrorCode() == 0) {
                    aVar2 = new com.baidu.tieba.personCenter.c.a();
                    aVar2.a(bVar);
                    aVar2.aOG();
                }
                aVar = this.epI.epG;
                aVar.a(aVar2);
            }
        }
    }
}
