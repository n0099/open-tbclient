package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dfm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i, int i2) {
        super(i, i2);
        this.dfm = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        r1 = r5.dfm.lw(r0);
     */
    @Override // com.baidu.adp.framework.listener.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BackgroundGroupActivity backgroundGroupActivity;
        d.a aVar;
        com.baidu.tieba.themeCenter.dressCenter.k kVar;
        List<c> list;
        DressItemData lw;
        BackgroundGroupActivity backgroundGroupActivity2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    backgroundGroupActivity2 = this.dfm.dfh;
                    backgroundGroupActivity2.showToast(responsedMessage.getErrorString());
                    return;
                }
                int propId = ((BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()).getPropId();
                backgroundGroupActivity = this.dfm.dfh;
                if (propId == backgroundGroupActivity.getPropId() && lw != null) {
                    TiebaStatic.log(new aq("c10286").r("obj_id", propId).r("obj_type", lw.getFreeUserLevel()));
                }
                this.dfm.lv(propId);
                aVar = this.dfm.dfj;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dfm.mRecommand;
                list = this.dfm.dfi;
                aVar.a(error, errorString, kVar, list);
            }
        }
    }
}
