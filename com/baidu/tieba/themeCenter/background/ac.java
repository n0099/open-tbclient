package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ aa dfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(aa aaVar, int i, int i2) {
        super(i, i2);
        this.dfE = aaVar;
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
                    backgroundPreviewActivity = this.dfE.dfs;
                    backgroundPreviewActivity.showToast(responsedMessage.getErrorString());
                    return;
                }
                ap apVar = new ap("c10286");
                dressItemData = this.dfE.deW;
                ap r = apVar.r("obj_id", dressItemData.getPropsId());
                dressItemData2 = this.dfE.deW;
                TiebaStatic.log(r.r("obj_type", dressItemData2.getFreeUserLevel()));
                dressItemData3 = this.dfE.deW;
                dressItemData3.setInUse(true);
                this.dfE.azp();
            }
        }
    }
}
