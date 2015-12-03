package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ aa dFq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(aa aaVar, int i, int i2) {
        super(i, i2);
        this.dFq = aaVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        DressItemData dressItemData;
        DressItemData dressItemData2;
        DressItemData dressItemData3;
        DressItemData dressItemData4;
        BackgroundPreviewActivity backgroundPreviewActivity;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (responsedMessage.getError() != 2270014) {
                        backgroundPreviewActivity = this.dFq.dFe;
                        backgroundPreviewActivity.showToast(responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                av avVar = new av("c10286");
                dressItemData = this.dFq.dEF;
                av r = avVar.r("obj_id", dressItemData.getPropsId());
                dressItemData2 = this.dFq.dEF;
                TiebaStatic.log(r.r("obj_type", dressItemData2.getFreeUserLevel()));
                dressItemData3 = this.dFq.dEF;
                dressItemData3.setInUse(true);
                this.dFq.aFv();
                dressItemData4 = this.dFq.dEF;
                com.baidu.tbadk.core.sharedPref.b.tZ().putInt("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), dressItemData4.getPropsId());
            }
        }
    }
}
