package com.baidu.tieba.write.selectpoi;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.write.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.write.data.LocationSearchResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SearchLocationActivity dUb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SearchLocationActivity searchLocationActivity, int i, int i2) {
        super(i, i2);
        this.dUb = searchLocationActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        h hVar;
        com.baidu.tieba.write.data.b bVar;
        h hVar2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.dUb.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.dUb.getResources().getString(n.j.neterror) : responsedMessage.getErrorString());
                    return;
                }
                if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                    this.dUb.dTU = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                }
                if (responsedMessage instanceof LocationSearchResponseMessage) {
                    this.dUb.dTU = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                }
                hVar = this.dUb.dTV;
                bVar = this.dUb.dTU;
                hVar.a(bVar);
                hVar2 = this.dUb.dTV;
                hVar2.notifyDataSetChanged();
            }
        }
    }
}
