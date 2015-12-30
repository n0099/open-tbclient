package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.recommendfrs.control.a.g;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeHttpResponse;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeRequest;
import com.baidu.tieba.recommendfrs.personalize.RecPersonalizeSocketResponse;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ g doU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i, int i2) {
        super(i, i2);
        this.doU = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    @Override // com.baidu.adp.framework.listener.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        g.a aVar;
        long j;
        g.a aVar2;
        g.a aVar3;
        boolean z = false;
        if (responsedMessage == null) {
            return;
        }
        aVar = this.doU.doT;
        if (aVar != null) {
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RecPersonalizeRequest) {
                    RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                    long requestTagCode = recPersonalizeRequest.getRequestTagCode();
                    z = recPersonalizeRequest.getLoadType() == 1;
                    j = requestTagCode;
                    if (responsedMessage.getError() != 0) {
                        DataRes dataRes = null;
                        if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                            dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                        } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                            dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                        }
                        aVar2 = this.doU.doT;
                        aVar2.b(j, dataRes, z);
                        return;
                    }
                    aVar3 = this.doU.doT;
                    aVar3.b(j, responsedMessage.getError(), responsedMessage.getErrorString());
                    return;
                }
            }
            j = 0;
            if (responsedMessage.getError() != 0) {
            }
        }
    }
}
