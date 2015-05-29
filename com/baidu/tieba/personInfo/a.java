package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonInfoActivity bVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.bVe = personInfoActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        com.baidu.tbadk.data.h personPrivate;
        v vVar5;
        BlackListModel blackListModel;
        v vVar6;
        int i;
        com.baidu.tieba.tbadkCore.e.a aVar;
        ad adVar;
        v vVar7;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        ad adVar2;
        v vVar8;
        com.baidu.tieba.tbadkCore.e.a aVar4;
        v vVar9;
        v vVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                vVar9 = this.bVe.bUT;
                if (vVar9.getUniqueId() != null) {
                    vVar10 = this.bVe.bUT;
                    if (vVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.bVe.aFs;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.bVe.aFs;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bVe.aFs = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    vVar8 = this.bVe.bUT;
                    vVar8.a(profileSocketResponseMessage);
                } else {
                    adVar2 = this.bVe.bUU;
                    adVar2.hideProgress();
                    this.bVe.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bVe.getResources().getString(com.baidu.tieba.t.neterror) : responsedMessage.getErrorString());
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.bVe.aFs;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.bVe.aFs;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bVe.aFs = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    vVar7 = this.bVe.bUT;
                    vVar7.a(profileHttpResponseMessage);
                } else {
                    adVar = this.bVe.bUU;
                    adVar.hideProgress();
                    this.bVe.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bVe.getResources().getString(com.baidu.tieba.t.neterror) : responsedMessage.getErrorString());
                }
            }
            vVar = this.bVe.bUT;
            if (vVar != null) {
                vVar5 = this.bVe.bUT;
                if (vVar5.getUserData() != null) {
                    blackListModel = this.bVe.bUS;
                    vVar6 = this.bVe.bUT;
                    if (vVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            vVar2 = this.bVe.bUT;
            if (vVar2 != null) {
                vVar3 = this.bVe.bUT;
                if (vVar3.getIsSelf()) {
                    vVar4 = this.bVe.bUT;
                    UserData userData = vVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.j.l(5, personPrivate.yT());
                        com.baidu.tbadk.core.a.j.l(3, personPrivate.yR());
                        com.baidu.tbadk.core.a.j.l(4, personPrivate.yS());
                        com.baidu.tbadk.core.a.j.l(2, personPrivate.yQ());
                    }
                }
            }
        }
    }
}
