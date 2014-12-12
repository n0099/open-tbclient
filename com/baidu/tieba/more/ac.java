package com.baidu.tieba.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ab buA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(ab abVar, int i, int i2) {
        super(i, i2);
        this.buA = abVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.tbadkCore.d.a aVar;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        com.baidu.tieba.tbadkCore.d.a aVar3;
        com.baidu.tieba.tbadkCore.d.a aVar4;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() == null || this.buA.getUniqueId() == null || this.buA.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage instanceof ProfileSocketResponseMessage) {
                    ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                    aVar3 = this.buA.aCg;
                    if (aVar3 != null) {
                        long downSize = profileSocketResponseMessage.getDownSize();
                        long costTime = profileSocketResponseMessage.getCostTime();
                        aVar4 = this.buA.aCg;
                        aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                        this.buA.aCg = null;
                    }
                    this.buA.a(profileSocketResponseMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                    aVar = this.buA.aCg;
                    if (aVar != null) {
                        long downSize2 = profileHttpResponseMessage.getDownSize();
                        long costTime2 = profileHttpResponseMessage.getCostTime();
                        aVar2 = this.buA.aCg;
                        aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                        this.buA.aCg = null;
                    }
                    this.buA.a(profileHttpResponseMessage);
                }
            }
        }
    }
}
