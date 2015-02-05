package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonInfoActivity bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.bJX = personInfoActivity;
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
        com.baidu.tieba.tbadkCore.d.a aVar;
        ae aeVar;
        v vVar7;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        com.baidu.tieba.tbadkCore.d.a aVar3;
        ae aeVar2;
        v vVar8;
        com.baidu.tieba.tbadkCore.d.a aVar4;
        v vVar9;
        v vVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                vVar9 = this.bJX.bJM;
                if (vVar9.getUniqueId() != null) {
                    vVar10 = this.bJX.bJM;
                    if (vVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.bJX.aDe;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.bJX.aDe;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bJX.aDe = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    vVar8 = this.bJX.bJM;
                    vVar8.a(profileSocketResponseMessage);
                } else {
                    aeVar2 = this.bJX.bJN;
                    aeVar2.hideProgress();
                    this.bJX.showToast(profileSocketResponseMessage.getErrorString());
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.bJX.aDe;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.bJX.aDe;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bJX.aDe = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    vVar7 = this.bJX.bJM;
                    vVar7.a(profileHttpResponseMessage);
                } else {
                    aeVar = this.bJX.bJN;
                    aeVar.hideProgress();
                    this.bJX.showToast(profileHttpResponseMessage.getErrorString());
                }
            }
            vVar = this.bJX.bJM;
            if (vVar != null) {
                vVar5 = this.bJX.bJM;
                if (vVar5.getUserData() != null) {
                    blackListModel = this.bJX.bJL;
                    vVar6 = this.bJX.bJM;
                    blackListModel.setMaskType(vVar6.getUserData().isMask() ? 1 : 0);
                }
            }
            vVar2 = this.bJX.bJM;
            if (vVar2 != null) {
                vVar3 = this.bJX.bJM;
                if (vVar3.getIsSelf()) {
                    vVar4 = this.bJX.bJM;
                    UserData userData = vVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.account.o.n(5, personPrivate.uK());
                        com.baidu.tbadk.core.account.o.n(3, personPrivate.uI());
                        com.baidu.tbadk.core.account.o.n(4, personPrivate.uJ());
                        com.baidu.tbadk.core.account.o.n(2, personPrivate.uH());
                    }
                }
            }
        }
    }
}
