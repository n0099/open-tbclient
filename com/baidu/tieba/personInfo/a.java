package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonInfoActivity bVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.bVf = personInfoActivity;
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
                vVar9 = this.bVf.bUU;
                if (vVar9.getUniqueId() != null) {
                    vVar10 = this.bVf.bUU;
                    if (vVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.bVf.aFt;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.bVf.aFt;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bVf.aFt = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    vVar8 = this.bVf.bUU;
                    vVar8.a(profileSocketResponseMessage);
                } else {
                    adVar2 = this.bVf.bUV;
                    adVar2.hideProgress();
                    this.bVf.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bVf.getResources().getString(com.baidu.tieba.t.neterror) : responsedMessage.getErrorString());
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.bVf.aFt;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.bVf.aFt;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bVf.aFt = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    vVar7 = this.bVf.bUU;
                    vVar7.a(profileHttpResponseMessage);
                } else {
                    adVar = this.bVf.bUV;
                    adVar.hideProgress();
                    this.bVf.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bVf.getResources().getString(com.baidu.tieba.t.neterror) : responsedMessage.getErrorString());
                }
            }
            vVar = this.bVf.bUU;
            if (vVar != null) {
                vVar5 = this.bVf.bUU;
                if (vVar5.getUserData() != null) {
                    blackListModel = this.bVf.bUT;
                    vVar6 = this.bVf.bUU;
                    if (vVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            vVar2 = this.bVf.bUU;
            if (vVar2 != null) {
                vVar3 = this.bVf.bUU;
                if (vVar3.getIsSelf()) {
                    vVar4 = this.bVf.bUU;
                    UserData userData = vVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.j.l(5, personPrivate.yU());
                        com.baidu.tbadk.core.a.j.l(3, personPrivate.yS());
                        com.baidu.tbadk.core.a.j.l(4, personPrivate.yT());
                        com.baidu.tbadk.core.a.j.l(2, personPrivate.yR());
                    }
                }
            }
        }
    }
}
