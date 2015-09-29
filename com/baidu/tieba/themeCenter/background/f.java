package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d deM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i, int i2) {
        super(i, i2);
        this.deM = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        r1 = r5.deM.lu(r0);
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
        DressItemData lu;
        BackgroundGroupActivity backgroundGroupActivity2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    backgroundGroupActivity2 = this.deM.deH;
                    backgroundGroupActivity2.showToast(responsedMessage.getErrorString());
                    return;
                }
                int propId = ((BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()).getPropId();
                backgroundGroupActivity = this.deM.deH;
                if (propId == backgroundGroupActivity.getPropId() && lu != null) {
                    TiebaStatic.log(new ap("c10286").r("obj_id", propId).r("obj_type", lu.getFreeUserLevel()));
                }
                this.deM.lt(propId);
                aVar = this.deM.deJ;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.deM.mRecommand;
                list = this.deM.deI;
                aVar.a(error, errorString, kVar, list);
            }
        }
    }
}
