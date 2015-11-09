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
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.cue = personInfoActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        com.baidu.tbadk.data.f personPrivate;
        y yVar5;
        BlackListModel blackListModel;
        y yVar6;
        int i;
        com.baidu.tieba.tbadkCore.e.a aVar;
        aj ajVar;
        y yVar7;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        aj ajVar2;
        y yVar8;
        com.baidu.tieba.tbadkCore.e.a aVar4;
        y yVar9;
        y yVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                yVar9 = this.cue.ctR;
                if (yVar9.getUniqueId() != null) {
                    yVar10 = this.cue.ctR;
                    if (yVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.cue.aMt;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.cue.aMt;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.cue.aMt = null;
                }
                if (profileSocketResponseMessage.getError() != 0) {
                    ajVar2 = this.cue.ctS;
                    ajVar2.hideProgress();
                    this.cue.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cue.getResources().getString(i.h.neterror) : responsedMessage.getErrorString());
                } else {
                    responsedMessage.getOrginalMessage();
                    yVar8 = this.cue.ctR;
                    yVar8.a(profileSocketResponseMessage);
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.cue.aMt;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.cue.aMt;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.cue.aMt = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    yVar7 = this.cue.ctR;
                    yVar7.a(profileHttpResponseMessage);
                } else {
                    ajVar = this.cue.ctS;
                    ajVar.hideProgress();
                    this.cue.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cue.getResources().getString(i.h.neterror) : responsedMessage.getErrorString());
                }
            }
            yVar = this.cue.ctR;
            if (yVar != null) {
                yVar5 = this.cue.ctR;
                if (yVar5.getUserData() != null) {
                    blackListModel = this.cue.ctQ;
                    yVar6 = this.cue.ctR;
                    if (yVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            yVar2 = this.cue.ctR;
            if (yVar2 != null) {
                yVar3 = this.cue.ctR;
                if (yVar3.getIsSelf()) {
                    yVar4 = this.cue.ctR;
                    UserData userData = yVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.h.w(5, personPrivate.Ae());
                        com.baidu.tbadk.core.a.h.w(3, personPrivate.Ac());
                        com.baidu.tbadk.core.a.h.w(4, personPrivate.Ad());
                        com.baidu.tbadk.core.a.h.w(2, personPrivate.Ab());
                    }
                }
            }
        }
    }
}
