package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.themeCenter.background.o;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ o dMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i, int i2) {
        super(i, i2);
        this.dMw = oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        r1 = r5.dMw.nw(r0);
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
        DressItemData nw;
        BackgroundListActivity backgroundListActivity2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (responsedMessage.getError() != 2270014) {
                        backgroundListActivity2 = this.dMw.dMp;
                        backgroundListActivity2.showToast(responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                int propId = ((BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()).getPropId();
                backgroundListActivity = this.dMw.dMp;
                if (propId == backgroundListActivity.getPropId() && nw != null) {
                    TiebaStatic.log(new av("c10286").r("obj_id", propId).r("obj_type", nw.getFreeUserLevel()));
                }
                com.baidu.tbadk.core.sharedPref.b.tJ().putInt("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                this.dMw.nv(propId);
                aVar = this.dMw.dMs;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dMw.mRecommand;
                list = this.dMw.dMq;
                aVar.a(error, errorString, kVar, list);
            }
        }
    }
}
