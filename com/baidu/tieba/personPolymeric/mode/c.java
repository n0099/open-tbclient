package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.personPolymeric.c.n;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericHttpResMsg;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericSocketResMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonPolymericModel eIt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PersonPolymericModel personPolymericModel, int i, int i2) {
        super(i, i2);
        this.eIt = personPolymericModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        b bVar;
        n nVar;
        int i;
        n nVar2;
        b bVar2;
        n nVar3;
        n nVar4;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            if (((responsedMessage instanceof PersonPolymericHttpResMsg) || (responsedMessage instanceof PersonPolymericSocketResMsg)) && this.eIt.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getError() != 0) {
                    bVar = this.eIt.eIq;
                    nVar = this.eIt.mPersonPolymericData;
                    bVar.a(null, nVar.hasMore());
                    return;
                }
                PersonPolymericModel personPolymericModel = this.eIt;
                i = personPolymericModel.pageIndex;
                personPolymericModel.pageIndex = i + 1;
                nVar2 = this.eIt.mPersonPolymericData;
                nVar2.aSA();
                bVar2 = this.eIt.eIq;
                nVar3 = this.eIt.mPersonPolymericData;
                nVar4 = this.eIt.mPersonPolymericData;
                bVar2.a(nVar3, nVar4.hasMore());
            }
        }
    }
}
