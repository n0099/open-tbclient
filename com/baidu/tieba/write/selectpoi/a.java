package com.baidu.tieba.write.selectpoi;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.write.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.write.data.LocationSearchResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SearchLocationActivity dlO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SearchLocationActivity searchLocationActivity, int i, int i2) {
        super(i, i2);
        this.dlO = searchLocationActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        h hVar;
        com.baidu.tieba.write.data.b bVar;
        h hVar2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.dlO.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.dlO.getResources().getString(i.h.neterror) : responsedMessage.getErrorString());
                    return;
                }
                if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                    this.dlO.dlH = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                }
                if (responsedMessage instanceof LocationSearchResponseMessage) {
                    this.dlO.dlH = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                }
                hVar = this.dlO.dlI;
                bVar = this.dlO.dlH;
                hVar.a(bVar);
                hVar2 = this.dlO.dlI;
                hVar2.notifyDataSetChanged();
            }
        }
    }
}
