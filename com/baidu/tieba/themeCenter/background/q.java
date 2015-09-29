package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.themeCenter.background.o;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ o dfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i, int i2) {
        super(i, i2);
        this.dfi = oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        r1 = r5.dfi.lu(r0);
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
        DressItemData lu;
        BackgroundListActivity backgroundListActivity2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    backgroundListActivity2 = this.dfi.dfd;
                    backgroundListActivity2.showToast(responsedMessage.getErrorString());
                    return;
                }
                int propId = ((BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()).getPropId();
                backgroundListActivity = this.dfi.dfd;
                if (propId == backgroundListActivity.getPropId() && lu != null) {
                    TiebaStatic.log(new ap("c10286").r("obj_id", propId).r("obj_type", lu.getFreeUserLevel()));
                }
                this.dfi.lt(propId);
                aVar = this.dfi.dff;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dfi.mRecommand;
                list = this.dfi.dfe;
                aVar.a(error, errorString, kVar, list);
            }
        }
    }
}
