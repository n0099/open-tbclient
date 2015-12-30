package com.baidu.tieba.setting.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ c dsO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, int i2) {
        super(i, i2);
        this.dsO = cVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.tbadkCore.d.a aVar;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        com.baidu.tieba.tbadkCore.d.a aVar3;
        com.baidu.tieba.tbadkCore.d.a aVar4;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() == null || this.dsO.getUniqueId() == null || this.dsO.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage instanceof ProfileSocketResponseMessage) {
                    ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                    aVar3 = this.dsO.aUT;
                    if (aVar3 != null) {
                        long downSize = profileSocketResponseMessage.getDownSize();
                        long costTime = profileSocketResponseMessage.getCostTime();
                        aVar4 = this.dsO.aUT;
                        aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                        this.dsO.aUT = null;
                    }
                    this.dsO.a(profileSocketResponseMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                    aVar = this.dsO.aUT;
                    if (aVar != null) {
                        long downSize2 = profileHttpResponseMessage.getDownSize();
                        long costTime2 = profileHttpResponseMessage.getCostTime();
                        aVar2 = this.dsO.aUT;
                        aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                        this.dsO.aUT = null;
                    }
                    this.dsO.a(profileHttpResponseMessage);
                }
            }
        }
    }
}
