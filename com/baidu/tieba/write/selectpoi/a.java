package com.baidu.tieba.write.selectpoi;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.location.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationSearchResponseMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SearchLocationActivity cvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SearchLocationActivity searchLocationActivity, int i, int i2) {
        super(i, i2);
        this.cvi = searchLocationActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        g gVar;
        com.baidu.tieba.tbadkCore.location.l lVar;
        g gVar2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.cvi.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cvi.getResources().getString(y.neterror) : responsedMessage.getErrorString());
                    return;
                }
                if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                    this.cvi.cvb = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                }
                if (responsedMessage instanceof LocationSearchResponseMessage) {
                    this.cvi.cvb = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                }
                gVar = this.cvi.cvc;
                lVar = this.cvi.cvb;
                gVar.a(lVar);
                gVar2 = this.cvi.cvc;
                gVar2.notifyDataSetChanged();
            }
        }
    }
}
