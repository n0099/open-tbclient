package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.themeCenter.background.o;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ o dho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i, int i2) {
        super(i, i2);
        this.dho = oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        r1 = r5.dho.lK(r0);
     */
    @Override // com.baidu.adp.framework.listener.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BackgroundListActivity backgroundListActivity;
        o.a aVar;
        com.baidu.tieba.themeCenter.dressCenter.k kVar;
        List<DressItemData> list;
        DressItemData lK;
        BackgroundListActivity backgroundListActivity2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    backgroundListActivity2 = this.dho.dhj;
                    backgroundListActivity2.showToast(responsedMessage.getErrorString());
                    return;
                }
                int propId = ((BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()).getPropId();
                backgroundListActivity = this.dho.dhj;
                if (propId == backgroundListActivity.getPropId() && lK != null) {
                    TiebaStatic.log(new aq("c10286").r("obj_id", propId).r("obj_type", lK.getFreeUserLevel()));
                }
                this.dho.lJ(propId);
                aVar = this.dho.dhl;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dho.mRecommand;
                list = this.dho.dhk;
                aVar.a(error, errorString, kVar, list);
            }
        }
    }
}
