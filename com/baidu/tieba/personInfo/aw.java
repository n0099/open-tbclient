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
public class aw extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(d dVar, int i, int i2) {
        super(i, i2);
        this.cWV = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        bb bbVar4;
        com.baidu.tbadk.data.f personPrivate;
        bb bbVar5;
        BlackListModel blackListModel;
        bb bbVar6;
        int i;
        com.baidu.tieba.tbadkCore.d.a aVar;
        be beVar;
        FrameLayout frameLayout;
        be beVar2;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        bb bbVar7;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        com.baidu.tieba.tbadkCore.d.a aVar3;
        be beVar3;
        FrameLayout frameLayout4;
        be beVar4;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        bb bbVar8;
        com.baidu.tieba.tbadkCore.d.a aVar4;
        bb bbVar9;
        bb bbVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                bbVar9 = this.cWV.cRx;
                if (bbVar9.getUniqueId() != null) {
                    bbVar10 = this.cWV.cRx;
                    if (bbVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                aVar3 = this.cWV.aUT;
                if (aVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    aVar4 = this.cWV.aUT;
                    aVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.cWV.aUT = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    responsedMessage.getOrginalMessage();
                    bbVar8 = this.cWV.cRx;
                    bbVar8.a(profileSocketResponseMessage);
                } else {
                    this.cWV.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cWV.getResources().getString(n.j.neterror) : responsedMessage.getErrorString());
                    beVar3 = this.cWV.cWi;
                    if (beVar3 != null) {
                        frameLayout4 = this.cWV.cWp;
                        if (frameLayout4 != null) {
                            beVar4 = this.cWV.cWi;
                            beVar4.hideProgress();
                            d dVar = this.cWV;
                            frameLayout5 = this.cWV.cWp;
                            dVar.au(frameLayout5);
                            d dVar2 = this.cWV;
                            frameLayout6 = this.cWV.cWp;
                            dVar2.showNetRefreshView(frameLayout6, this.cWV.getPageContext().getResources().getString(n.j.neterror), false);
                        }
                    }
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                aVar = this.cWV.aUT;
                if (aVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    aVar2 = this.cWV.aUT;
                    aVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.cWV.aUT = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    bbVar7 = this.cWV.cRx;
                    bbVar7.a(profileHttpResponseMessage);
                } else {
                    this.cWV.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.cWV.getResources().getString(n.j.neterror) : responsedMessage.getErrorString());
                    beVar = this.cWV.cWi;
                    if (beVar != null) {
                        frameLayout = this.cWV.cWp;
                        if (frameLayout != null) {
                            beVar2 = this.cWV.cWi;
                            beVar2.hideProgress();
                            d dVar3 = this.cWV;
                            frameLayout2 = this.cWV.cWp;
                            dVar3.au(frameLayout2);
                            d dVar4 = this.cWV;
                            frameLayout3 = this.cWV.cWp;
                            dVar4.showNetRefreshView(frameLayout3, this.cWV.getPageContext().getResources().getString(n.j.neterror), false);
                        }
                    }
                }
            }
            bbVar = this.cWV.cRx;
            if (bbVar != null) {
                bbVar5 = this.cWV.cRx;
                if (bbVar5.getUserData() != null) {
                    blackListModel = this.cWV.cWj;
                    bbVar6 = this.cWV.cRx;
                    if (bbVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            bbVar2 = this.cWV.cRx;
            if (bbVar2 != null) {
                bbVar3 = this.cWV.cRx;
                if (bbVar3.getIsSelf()) {
                    bbVar4 = this.cWV.cRx;
                    UserData userData = bbVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.h.v(5, personPrivate.AP());
                        com.baidu.tbadk.core.a.h.v(3, personPrivate.AN());
                        com.baidu.tbadk.core.a.h.v(4, personPrivate.AO());
                        com.baidu.tbadk.core.a.h.v(2, personPrivate.AM());
                    }
                }
            }
        }
    }
}
