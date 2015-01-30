package com.baidu.tieba.selectpoi;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationSearchResponseMessage;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SearchLocationActivity bOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SearchLocationActivity searchLocationActivity, int i, int i2) {
        super(i, i2);
        this.bOH = searchLocationActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        h hVar;
        com.baidu.tieba.tbadkCore.location.k kVar;
        h hVar2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.bOH.showToast(responsedMessage.getErrorString());
                    return;
                }
                if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                    this.bOH.bOB = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                }
                if (responsedMessage instanceof LocationSearchResponseMessage) {
                    this.bOH.bOB = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                }
                hVar = this.bOH.bOC;
                kVar = this.bOH.bOB;
                hVar.a(kVar);
                hVar2 = this.bOH.bOC;
                hVar2.notifyDataSetChanged();
            }
        }
    }
}
