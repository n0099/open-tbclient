package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonInfoActivity bSh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.bSh = personInfoActivity;
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
        ae aeVar;
        v vVar7;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        ae aeVar2;
        v vVar8;
        com.baidu.tieba.tbadkCore.e.a aVar4;
        v vVar9;
        v vVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                vVar9 = this.bSh.bRW;
                if (vVar9.getUniqueId() != null) {
                    vVar10 = this.bSh.bRW;
                    if (vVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.bSh.aDi;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.bSh.aDi;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bSh.aDi = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    vVar8 = this.bSh.bRW;
                    vVar8.a(profileSocketResponseMessage);
                } else {
                    aeVar2 = this.bSh.bRX;
                    aeVar2.hideProgress();
                    this.bSh.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bSh.getResources().getString(com.baidu.tieba.y.neterror) : responsedMessage.getErrorString());
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.bSh.aDi;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.bSh.aDi;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bSh.aDi = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    vVar7 = this.bSh.bRW;
                    vVar7.a(profileHttpResponseMessage);
                } else {
                    aeVar = this.bSh.bRX;
                    aeVar.hideProgress();
                    this.bSh.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bSh.getResources().getString(com.baidu.tieba.y.neterror) : responsedMessage.getErrorString());
                }
            }
            vVar = this.bSh.bRW;
            if (vVar != null) {
                vVar5 = this.bSh.bRW;
                if (vVar5.getUserData() != null) {
                    blackListModel = this.bSh.bRV;
                    vVar6 = this.bSh.bRW;
                    if (vVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            vVar2 = this.bSh.bRW;
            if (vVar2 != null) {
                vVar3 = this.bSh.bRW;
                if (vVar3.getIsSelf()) {
                    vVar4 = this.bSh.bRW;
                    UserData userData = vVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.j.l(5, personPrivate.ya());
                        com.baidu.tbadk.core.a.j.l(3, personPrivate.xY());
                        com.baidu.tbadk.core.a.j.l(4, personPrivate.xZ());
                        com.baidu.tbadk.core.a.j.l(2, personPrivate.xX());
                    }
                }
            }
        }
    }
}
