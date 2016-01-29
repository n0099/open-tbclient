package com.baidu.tieba.personInfo;

import android.widget.FrameLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(f fVar, int i, int i2) {
        super(i, i2);
        this.diG = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        com.baidu.tbadk.data.f personPrivate;
        bf bfVar5;
        BlackListModel blackListModel;
        bf bfVar6;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar;
        bi biVar;
        FrameLayout frameLayout;
        bi biVar2;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        bf bfVar7;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        bi biVar3;
        FrameLayout frameLayout4;
        bi biVar4;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        bf bfVar8;
        com.baidu.tieba.tbadkCore.d.b bVar4;
        bf bfVar9;
        bf bfVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                bfVar9 = this.diG.dbl;
                if (bfVar9.getUniqueId() != null) {
                    bfVar10 = this.diG.dbl;
                    if (bfVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                bVar3 = this.diG.aXf;
                if (bVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    bVar4 = this.diG.aXf;
                    bVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.diG.aXf = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    responsedMessage.getOrginalMessage();
                    bfVar8 = this.diG.dbl;
                    bfVar8.a(profileSocketResponseMessage);
                } else {
                    this.diG.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.diG.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
                    biVar3 = this.diG.dhR;
                    if (biVar3 != null) {
                        frameLayout4 = this.diG.dhY;
                        if (frameLayout4 != null) {
                            biVar4 = this.diG.dhR;
                            biVar4.Oz();
                            f fVar = this.diG;
                            frameLayout5 = this.diG.dhY;
                            fVar.aK(frameLayout5);
                            f fVar2 = this.diG;
                            frameLayout6 = this.diG.dhY;
                            fVar2.showNetRefreshView(frameLayout6, this.diG.getPageContext().getResources().getString(t.j.neterror), false);
                        }
                    }
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                bVar = this.diG.aXf;
                if (bVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    bVar2 = this.diG.aXf;
                    bVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.diG.aXf = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    bfVar7 = this.diG.dbl;
                    bfVar7.a(profileHttpResponseMessage);
                } else {
                    this.diG.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.diG.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
                    biVar = this.diG.dhR;
                    if (biVar != null) {
                        frameLayout = this.diG.dhY;
                        if (frameLayout != null) {
                            biVar2 = this.diG.dhR;
                            biVar2.Oz();
                            f fVar3 = this.diG;
                            frameLayout2 = this.diG.dhY;
                            fVar3.aK(frameLayout2);
                            f fVar4 = this.diG;
                            frameLayout3 = this.diG.dhY;
                            fVar4.showNetRefreshView(frameLayout3, this.diG.getPageContext().getResources().getString(t.j.neterror), false);
                        }
                    }
                }
            }
            bfVar = this.diG.dbl;
            if (bfVar != null) {
                bfVar5 = this.diG.dbl;
                if (bfVar5.getUserData() != null) {
                    blackListModel = this.diG.dhS;
                    bfVar6 = this.diG.dbl;
                    if (bfVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            bfVar2 = this.diG.dbl;
            if (bfVar2 != null) {
                bfVar3 = this.diG.dbl;
                if (bfVar3.getIsSelf()) {
                    bfVar4 = this.diG.dbl;
                    UserData userData = bfVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.h.r(5, personPrivate.Cf());
                        com.baidu.tbadk.core.a.h.r(3, personPrivate.Cd());
                        com.baidu.tbadk.core.a.h.r(4, personPrivate.Ce());
                        com.baidu.tbadk.core.a.h.r(2, personPrivate.Cc());
                    }
                }
            }
        }
    }
}
