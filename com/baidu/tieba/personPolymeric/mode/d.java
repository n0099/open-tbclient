package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.personPolymeric.c.n;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericHttpResMsg;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericSocketResMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ c eRn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, int i2) {
        super(i, i2);
        this.eRn = cVar;
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
            if (((responsedMessage instanceof PersonPolymericHttpResMsg) || (responsedMessage instanceof PersonPolymericSocketResMsg)) && this.eRn.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getError() != 0) {
                    bVar = this.eRn.eRk;
                    nVar = this.eRn.mPersonPolymericData;
                    bVar.a(null, nVar.hasMore());
                    return;
                }
                c cVar = this.eRn;
                i = cVar.pageIndex;
                cVar.pageIndex = i + 1;
                nVar2 = this.eRn.mPersonPolymericData;
                nVar2.aWf();
                bVar2 = this.eRn.eRk;
                nVar3 = this.eRn.mPersonPolymericData;
                nVar4 = this.eRn.mPersonPolymericData;
                bVar2.a(nVar3, nVar4.hasMore());
            }
        }
    }
}
