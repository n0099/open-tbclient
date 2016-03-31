package com.baidu.tieba.setting.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ c ebm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, int i2) {
        super(i, i2);
        this.ebm = cVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.tbadkCore.d.b bVar;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        com.baidu.tieba.tbadkCore.d.b bVar4;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() == null || this.ebm.getUniqueId() == null || this.ebm.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage instanceof ProfileSocketResponseMessage) {
                    ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                    bVar3 = this.ebm.bbO;
                    if (bVar3 != null) {
                        long downSize = profileSocketResponseMessage.getDownSize();
                        long costTime = profileSocketResponseMessage.getCostTime();
                        bVar4 = this.ebm.bbO;
                        bVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                        this.ebm.bbO = null;
                    }
                    this.ebm.a(profileSocketResponseMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                    bVar = this.ebm.bbO;
                    if (bVar != null) {
                        long downSize2 = profileHttpResponseMessage.getDownSize();
                        long costTime2 = profileHttpResponseMessage.getCostTime();
                        bVar2 = this.ebm.bbO;
                        bVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                        this.ebm.bbO = null;
                    }
                    this.ebm.a(profileHttpResponseMessage);
                }
            }
        }
    }
}
