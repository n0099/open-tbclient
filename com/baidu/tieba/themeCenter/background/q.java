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
    final /* synthetic */ o dET;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, int i, int i2) {
        super(i, i2);
        this.dET = oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        r1 = r5.dET.mU(r0);
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
        DressItemData mU;
        BackgroundListActivity backgroundListActivity2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (responsedMessage.getError() != 2270014) {
                        backgroundListActivity2 = this.dET.dEM;
                        backgroundListActivity2.showToast(responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                int propId = ((BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()).getPropId();
                backgroundListActivity = this.dET.dEM;
                if (propId == backgroundListActivity.getPropId() && mU != null) {
                    TiebaStatic.log(new av("c10286").r("obj_id", propId).r("obj_type", mU.getFreeUserLevel()));
                }
                com.baidu.tbadk.core.sharedPref.b.tZ().putInt("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                this.dET.mT(propId);
                aVar = this.dET.dEP;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dET.mRecommand;
                list = this.dET.dEN;
                aVar.a(error, errorString, kVar, list);
            }
        }
    }
}
