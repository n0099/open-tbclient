package com.baidu.tieba.write.selectpoi;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import com.baidu.tieba.write.data.LocationSearchHttpResponsedMessage;
import com.baidu.tieba.write.data.LocationSearchResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SearchLocationActivity eZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SearchLocationActivity searchLocationActivity, int i, int i2) {
        super(i, i2);
        this.eZt = searchLocationActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        h hVar;
        com.baidu.tieba.write.data.b bVar;
        h hVar2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof LocationSearchHttpResponsedMessage) || (responsedMessage instanceof LocationSearchResponseMessage)) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.eZt.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.eZt.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
                    return;
                }
                if (responsedMessage instanceof LocationSearchHttpResponsedMessage) {
                    this.eZt.eZn = ((LocationSearchHttpResponsedMessage) responsedMessage).getLocationData();
                }
                if (responsedMessage instanceof LocationSearchResponseMessage) {
                    this.eZt.eZn = ((LocationSearchResponseMessage) responsedMessage).getLocationData();
                }
                hVar = this.eZt.eZo;
                bVar = this.eZt.eZn;
                hVar.a(bVar);
                hVar2 = this.eZt.eZo;
                hVar2.notifyDataSetChanged();
            }
        }
    }
}
