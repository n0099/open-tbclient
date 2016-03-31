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
    final /* synthetic */ g dWl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i, int i2) {
        super(i, i2);
        this.dWl = gVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        g.a aVar;
        g.a aVar2;
        g.a aVar3;
        boolean z = false;
        if (responsedMessage == null) {
            return;
        }
        aVar = this.dWl.dWd;
        if (aVar != null) {
            long j = 0;
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RecPersonalizeRequest) {
                    RecPersonalizeRequest recPersonalizeRequest = (RecPersonalizeRequest) extra;
                    j = recPersonalizeRequest.getRequestTagCode();
                    z = recPersonalizeRequest.getLoadType() == 1;
                }
            }
            if (responsedMessage.getError() == 0) {
                DataRes dataRes = null;
                if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                    dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                }
                aVar2 = this.dWl.dWd;
                aVar2.b(j, dataRes, z);
            } else {
                aVar3 = this.dWl.dWd;
                aVar3.e(j, responsedMessage.getError(), responsedMessage.getErrorString());
            }
            if (!(responsedMessage instanceof RecPersonalizeSocketResponse)) {
                if (!(responsedMessage instanceof RecPersonalizeHttpResponse)) {
                    return;
                }
                this.dWl.k(responsedMessage);
                return;
            }
            this.dWl.j(responsedMessage);
        }
    }
}
