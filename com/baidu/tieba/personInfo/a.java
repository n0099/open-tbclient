package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonInfoActivity cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.cmR = personInfoActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        com.baidu.tbadk.data.g personPrivate;
        w wVar5;
        BlackListModel blackListModel;
        w wVar6;
        int i;
        com.baidu.tieba.tbadkCore.e.a aVar;
        ag agVar;
        w wVar7;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        ag agVar2;
        w wVar8;
        com.baidu.tieba.tbadkCore.e.a aVar4;
        w wVar9;
        w wVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                wVar9 = this.cmR.cmF;
                if (wVar9.getUniqueId() != null) {
                    wVar10 = this.cmR.cmF;
                    if (wVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.cmR.aNf;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.cmR.aNf;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.cmR.aNf = null;
                }
                if (profileSocketResponseMessage.getError() != 0) {
                    agVar2 = this.cmR.cmG;
                    agVar2.hideProgress();
                    this.cmR.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cmR.getResources().getString(i.h.neterror) : responsedMessage.getErrorString());
                } else {
                    responsedMessage.getOrginalMessage();
                    wVar8 = this.cmR.cmF;
                    wVar8.a(profileSocketResponseMessage);
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.cmR.aNf;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.cmR.aNf;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.cmR.aNf = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    wVar7 = this.cmR.cmF;
                    wVar7.a(profileHttpResponseMessage);
                } else {
                    agVar = this.cmR.cmG;
                    agVar.hideProgress();
                    this.cmR.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cmR.getResources().getString(i.h.neterror) : responsedMessage.getErrorString());
                }
            }
            wVar = this.cmR.cmF;
            if (wVar != null) {
                wVar5 = this.cmR.cmF;
                if (wVar5.getUserData() != null) {
                    blackListModel = this.cmR.cmE;
                    wVar6 = this.cmR.cmF;
                    if (wVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            wVar2 = this.cmR.cmF;
            if (wVar2 != null) {
                wVar3 = this.cmR.cmF;
                if (wVar3.getIsSelf()) {
                    wVar4 = this.cmR.cmF;
                    UserData userData = wVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.h.w(5, personPrivate.Ar());
                        com.baidu.tbadk.core.a.h.w(3, personPrivate.Ap());
                        com.baidu.tbadk.core.a.h.w(4, personPrivate.Aq());
                        com.baidu.tbadk.core.a.h.w(2, personPrivate.Ao());
                    }
                }
            }
        }
    }
}
