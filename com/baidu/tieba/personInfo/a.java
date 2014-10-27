package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PersonInfoActivity bED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PersonInfoActivity personInfoActivity, int i, int i2) {
        super(i, i2);
        this.bED = personInfoActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        com.baidu.tbadk.data.c personPrivate;
        v vVar5;
        com.baidu.tieba.model.d dVar;
        v vVar6;
        com.baidu.tieba.b.a aVar;
        ae aeVar;
        v vVar7;
        com.baidu.tieba.b.a aVar2;
        com.baidu.tieba.b.a aVar3;
        ae aeVar2;
        v vVar8;
        com.baidu.tieba.b.a aVar4;
        v vVar9;
        v vVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                vVar9 = this.bED.bEs;
                if (vVar9.getUniqueId() != null) {
                    vVar10 = this.bED.bEs;
                    if (vVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.bED.aAE;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.bED.aAE;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.bED.aAE = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    vVar8 = this.bED.bEs;
                    vVar8.a(profileSocketResponseMessage);
                } else {
                    aeVar2 = this.bED.bEt;
                    aeVar2.hideProgress();
                    this.bED.showToast(profileSocketResponseMessage.getErrorString());
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.bED.aAE;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.bED.aAE;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.bED.aAE = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    vVar7 = this.bED.bEs;
                    vVar7.a(profileHttpResponseMessage);
                } else {
                    aeVar = this.bED.bEt;
                    aeVar.hideProgress();
                    this.bED.showToast(profileHttpResponseMessage.getErrorString());
                }
            }
            vVar = this.bED.bEs;
            if (vVar != null) {
                vVar5 = this.bED.bEs;
                if (vVar5.getUserData() != null) {
                    dVar = this.bED.bEr;
                    vVar6 = this.bED.bEs;
                    dVar.setMaskType(vVar6.getUserData().isMask() ? 1 : 0);
                }
            }
            vVar2 = this.bED.bEs;
            if (vVar2 != null) {
                vVar3 = this.bED.bEs;
                if (vVar3.getIsSelf()) {
                    vVar4 = this.bED.bEs;
                    UserData userData = vVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.account.o.k(5, personPrivate.qV());
                        com.baidu.tbadk.core.account.o.k(3, personPrivate.qT());
                        com.baidu.tbadk.core.account.o.k(4, personPrivate.qU());
                        com.baidu.tbadk.core.account.o.k(2, personPrivate.qS());
                    }
                }
            }
        }
    }
}
