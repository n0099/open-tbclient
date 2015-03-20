package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ w caG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(w wVar, int i, int i2) {
        super(i, i2);
        this.caG = wVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        com.baidu.tieba.tbadkCore.e.a aVar4;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() == null || this.caG.getUniqueId() == null || this.caG.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage instanceof ProfileSocketResponseMessage) {
                    ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                    aVar3 = this.caG.aDi;
                    if (aVar3 != null) {
                        long downSize = profileSocketResponseMessage.getDownSize();
                        long costTime = profileSocketResponseMessage.getCostTime();
                        aVar4 = this.caG.aDi;
                        aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                        this.caG.aDi = null;
                    }
                    this.caG.a(profileSocketResponseMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                    aVar = this.caG.aDi;
                    if (aVar != null) {
                        long downSize2 = profileHttpResponseMessage.getDownSize();
                        long costTime2 = profileHttpResponseMessage.getCostTime();
                        aVar2 = this.caG.aDi;
                        aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                        this.caG.aDi = null;
                    }
                    this.caG.a(profileHttpResponseMessage);
                }
            }
        }
    }
}
