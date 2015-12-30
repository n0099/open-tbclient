package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d dMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i, int i2) {
        super(i, i2);
        this.dMb = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        r1 = r5.dMb.nw(r0);
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
        DressItemData nw;
        BackgroundGroupActivity backgroundGroupActivity2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (responsedMessage.getError() != 2270014) {
                        backgroundGroupActivity2 = this.dMb.dLX;
                        backgroundGroupActivity2.showToast(responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                int propId = ((BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()).getPropId();
                backgroundGroupActivity = this.dMb.dLX;
                if (propId == backgroundGroupActivity.getPropId() && nw != null) {
                    TiebaStatic.log(new av("c10286").r("obj_id", propId).r("obj_type", nw.getFreeUserLevel()));
                }
                com.baidu.tbadk.core.sharedPref.b.tJ().putInt("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                this.dMb.nv(propId);
                aVar = this.dMb.dLZ;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dMb.mRecommand;
                list = this.dMb.dLY;
                aVar.a(error, errorString, kVar, list);
            }
        }
    }
}
