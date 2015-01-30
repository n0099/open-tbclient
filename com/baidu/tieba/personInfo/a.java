package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonInfoActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.bJY = personInfoActivity;
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
                vVar9 = this.bJY.bJN;
                if (vVar9.getUniqueId() != null) {
                    vVar10 = this.bJY.bJN;
                    if (vVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.bJY.aDh;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.bJY.aDh;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bJY.aDh = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    vVar8 = this.bJY.bJN;
                    vVar8.a(profileSocketResponseMessage);
                } else {
                    aeVar2 = this.bJY.bJO;
                    aeVar2.hideProgress();
                    this.bJY.showToast(profileSocketResponseMessage.getErrorString());
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.bJY.aDh;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.bJY.aDh;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bJY.aDh = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    vVar7 = this.bJY.bJN;
                    vVar7.a(profileHttpResponseMessage);
                } else {
                    aeVar = this.bJY.bJO;
                    aeVar.hideProgress();
                    this.bJY.showToast(profileHttpResponseMessage.getErrorString());
                }
            }
            vVar = this.bJY.bJN;
            if (vVar != null) {
                vVar5 = this.bJY.bJN;
                if (vVar5.getUserData() != null) {
                    blackListModel = this.bJY.bJM;
                    vVar6 = this.bJY.bJN;
                    blackListModel.setMaskType(vVar6.getUserData().isMask() ? 1 : 0);
                }
            }
            vVar2 = this.bJY.bJN;
            if (vVar2 != null) {
                vVar3 = this.bJY.bJN;
                if (vVar3.getIsSelf()) {
                    vVar4 = this.bJY.bJN;
                    UserData userData = vVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.account.o.n(5, personPrivate.uQ());
                        com.baidu.tbadk.core.account.o.n(3, personPrivate.uO());
                        com.baidu.tbadk.core.account.o.n(4, personPrivate.uP());
                        com.baidu.tbadk.core.account.o.n(2, personPrivate.uN());
                    }
                }
            }
        }
    }
}
