package com.baidu.tieba.personInfo;

import android.widget.FrameLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.n;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(d dVar, int i, int i2) {
        super(i, i2);
        this.cSn = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        com.baidu.tbadk.data.f personPrivate;
        aw awVar5;
        BlackListModel blackListModel;
        aw awVar6;
        com.baidu.tieba.tbadkCore.d.a aVar;
        String errorString;
        az azVar;
        FrameLayout frameLayout;
        az azVar2;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        aw awVar7;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        com.baidu.tieba.tbadkCore.d.a aVar3;
        String errorString2;
        az azVar3;
        FrameLayout frameLayout4;
        az azVar4;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        aw awVar8;
        com.baidu.tieba.tbadkCore.d.a aVar4;
        aw awVar9;
        aw awVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                awVar9 = this.cSn.cMT;
                if (awVar9.getUniqueId() != null) {
                    awVar10 = this.cSn.cMT;
                    if (awVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.cSn.aRc;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.cSn.aRc;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.cSn.aRc = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    responsedMessage.getOrginalMessage();
                    awVar8 = this.cSn.cMT;
                    awVar8.a(profileSocketResponseMessage);
                } else {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString2 = this.cSn.getResources().getString(n.i.neterror);
                    } else {
                        errorString2 = responsedMessage.getErrorString();
                    }
                    this.cSn.showToast(errorString2);
                    azVar3 = this.cSn.cRH;
                    if (azVar3 != null) {
                        frameLayout4 = this.cSn.cRM;
                        if (frameLayout4 != null) {
                            azVar4 = this.cSn.cRH;
                            azVar4.hideProgress();
                            d dVar = this.cSn;
                            frameLayout5 = this.cSn.cRM;
                            dVar.ao(frameLayout5);
                            d dVar2 = this.cSn;
                            frameLayout6 = this.cSn.cRM;
                            dVar2.showNetRefreshView(frameLayout6, this.cSn.getPageContext().getResources().getString(n.i.neterror), false);
                        }
                    }
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.cSn.aRc;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.cSn.aRc;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.cSn.aRc = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    awVar7 = this.cSn.cMT;
                    awVar7.a(profileHttpResponseMessage);
                } else {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = this.cSn.getResources().getString(n.i.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    this.cSn.showToast(errorString);
                    azVar = this.cSn.cRH;
                    if (azVar != null) {
                        frameLayout = this.cSn.cRM;
                        if (frameLayout != null) {
                            azVar2 = this.cSn.cRH;
                            azVar2.hideProgress();
                            d dVar3 = this.cSn;
                            frameLayout2 = this.cSn.cRM;
                            dVar3.ao(frameLayout2);
                            d dVar4 = this.cSn;
                            frameLayout3 = this.cSn.cRM;
                            dVar4.showNetRefreshView(frameLayout3, this.cSn.getPageContext().getResources().getString(n.i.neterror), false);
                        }
                    }
                }
            }
            awVar = this.cSn.cMT;
            if (awVar != null) {
                awVar5 = this.cSn.cMT;
                if (awVar5.getUserData() != null) {
                    blackListModel = this.cSn.cRI;
                    awVar6 = this.cSn.cMT;
                    blackListModel.setMaskType(awVar6.getUserData().isMask() ? 1 : 0);
                }
            }
            awVar2 = this.cSn.cMT;
            if (awVar2 != null) {
                awVar3 = this.cSn.cMT;
                if (awVar3.getIsSelf()) {
                    awVar4 = this.cSn.cMT;
                    UserData userData = awVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.h.w(5, personPrivate.AZ());
                        com.baidu.tbadk.core.a.h.w(3, personPrivate.AX());
                        com.baidu.tbadk.core.a.h.w(4, personPrivate.AY());
                        com.baidu.tbadk.core.a.h.w(2, personPrivate.AW());
                    }
                }
            }
        }
    }
}
