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
    final /* synthetic */ d dEx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i, int i2) {
        super(i, i2);
        this.dEx = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        r1 = r5.dEx.mU(r0);
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
        DressItemData mU;
        BackgroundGroupActivity backgroundGroupActivity2;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (responsedMessage.getError() != 2270014) {
                        backgroundGroupActivity2 = this.dEx.dEt;
                        backgroundGroupActivity2.showToast(responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                int propId = ((BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()).getPropId();
                backgroundGroupActivity = this.dEx.dEt;
                if (propId == backgroundGroupActivity.getPropId() && mU != null) {
                    TiebaStatic.log(new av("c10286").r("obj_id", propId).r("obj_type", mU.getFreeUserLevel()));
                }
                com.baidu.tbadk.core.sharedPref.b.tZ().putInt("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                this.dEx.mT(propId);
                aVar = this.dEx.dEv;
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                kVar = this.dEx.mRecommand;
                list = this.dEx.dEu;
                aVar.a(error, errorString, kVar, list);
            }
        }
    }
}
