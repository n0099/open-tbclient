package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonInfoActivity bSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.bSx = personInfoActivity;
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
                vVar9 = this.bSx.bSm;
                if (vVar9.getUniqueId() != null) {
                    vVar10 = this.bSx.bSm;
                    if (vVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.bSx.aDq;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.bSx.aDq;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bSx.aDq = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    vVar8 = this.bSx.bSm;
                    vVar8.a(profileSocketResponseMessage);
                } else {
                    aeVar2 = this.bSx.bSn;
                    aeVar2.hideProgress();
                    this.bSx.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bSx.getResources().getString(com.baidu.tieba.y.neterror) : responsedMessage.getErrorString());
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.bSx.aDq;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.bSx.aDq;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bSx.aDq = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    vVar7 = this.bSx.bSm;
                    vVar7.a(profileHttpResponseMessage);
                } else {
                    aeVar = this.bSx.bSn;
                    aeVar.hideProgress();
                    this.bSx.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bSx.getResources().getString(com.baidu.tieba.y.neterror) : responsedMessage.getErrorString());
                }
            }
            vVar = this.bSx.bSm;
            if (vVar != null) {
                vVar5 = this.bSx.bSm;
                if (vVar5.getUserData() != null) {
                    blackListModel = this.bSx.bSl;
                    vVar6 = this.bSx.bSm;
                    if (vVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            vVar2 = this.bSx.bSm;
            if (vVar2 != null) {
                vVar3 = this.bSx.bSm;
                if (vVar3.getIsSelf()) {
                    vVar4 = this.bSx.bSm;
                    UserData userData = vVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.j.l(5, personPrivate.yg());
                        com.baidu.tbadk.core.a.j.l(3, personPrivate.ye());
                        com.baidu.tbadk.core.a.j.l(4, personPrivate.yf());
                        com.baidu.tbadk.core.a.j.l(2, personPrivate.yd());
                    }
                }
            }
        }
    }
}
