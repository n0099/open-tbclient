package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ aa dhK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(aa aaVar, int i, int i2) {
        super(i, i2);
        this.dhK = aaVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        DressItemData dressItemData;
        DressItemData dressItemData2;
        DressItemData dressItemData3;
        BackgroundPreviewActivity backgroundPreviewActivity;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    backgroundPreviewActivity = this.dhK.dhy;
                    backgroundPreviewActivity.showToast(responsedMessage.getErrorString());
                    return;
                }
                aq aqVar = new aq("c10286");
                dressItemData = this.dhK.dhc;
                aq r = aqVar.r("obj_id", dressItemData.getPropsId());
                dressItemData2 = this.dhK.dhc;
                TiebaStatic.log(r.r("obj_type", dressItemData2.getFreeUserLevel()));
                dressItemData3 = this.dhK.dhc;
                dressItemData3.setInUse(true);
                this.dhK.aAl();
            }
        }
    }
}
