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
public class bb extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(f fVar, int i, int i2) {
        super(i, i2);
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        com.baidu.tbadk.data.h personPrivate;
        bg bgVar5;
        BlackListModel blackListModel;
        bg bgVar6;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar;
        bj bjVar;
        FrameLayout frameLayout;
        bj bjVar2;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        bg bgVar7;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        bj bjVar3;
        FrameLayout frameLayout4;
        bj bjVar4;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        bg bgVar8;
        com.baidu.tieba.tbadkCore.d.b bVar4;
        bg bgVar9;
        bg bgVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                bgVar9 = this.this$0.dyP;
                if (bgVar9.getUniqueId() != null) {
                    bgVar10 = this.this$0.dyP;
                    if (bgVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                bVar3 = this.this$0.aXX;
                if (bVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    bVar4 = this.this$0.aXX;
                    bVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.this$0.aXX = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    responsedMessage.getOrginalMessage();
                    bgVar8 = this.this$0.dyP;
                    bgVar8.a(profileSocketResponseMessage);
                } else {
                    this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
                    bjVar3 = this.this$0.dFA;
                    if (bjVar3 != null) {
                        frameLayout4 = this.this$0.dFH;
                        if (frameLayout4 != null) {
                            bjVar4 = this.this$0.dFA;
                            bjVar4.Pl();
                            f fVar = this.this$0;
                            frameLayout5 = this.this$0.dFH;
                            fVar.aH(frameLayout5);
                            f fVar2 = this.this$0;
                            frameLayout6 = this.this$0.dFH;
                            fVar2.showNetRefreshView(frameLayout6, this.this$0.getPageContext().getResources().getString(t.j.neterror), false);
                        }
                    }
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                bVar = this.this$0.aXX;
                if (bVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    bVar2 = this.this$0.aXX;
                    bVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.this$0.aXX = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    bgVar7 = this.this$0.dyP;
                    bgVar7.a(profileHttpResponseMessage);
                } else {
                    this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
                    bjVar = this.this$0.dFA;
                    if (bjVar != null) {
                        frameLayout = this.this$0.dFH;
                        if (frameLayout != null) {
                            bjVar2 = this.this$0.dFA;
                            bjVar2.Pl();
                            f fVar3 = this.this$0;
                            frameLayout2 = this.this$0.dFH;
                            fVar3.aH(frameLayout2);
                            f fVar4 = this.this$0;
                            frameLayout3 = this.this$0.dFH;
                            fVar4.showNetRefreshView(frameLayout3, this.this$0.getPageContext().getResources().getString(t.j.neterror), false);
                        }
                    }
                }
            }
            bgVar = this.this$0.dyP;
            if (bgVar != null) {
                bgVar5 = this.this$0.dyP;
                if (bgVar5.getUserData() != null) {
                    blackListModel = this.this$0.dFB;
                    bgVar6 = this.this$0.dyP;
                    if (bgVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            bgVar2 = this.this$0.dyP;
            if (bgVar2 != null) {
                bgVar3 = this.this$0.dyP;
                if (bgVar3.getIsSelf()) {
                    bgVar4 = this.this$0.dyP;
                    UserData userData = bgVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.h.n(5, personPrivate.AE());
                        com.baidu.tbadk.core.a.h.n(3, personPrivate.AC());
                        com.baidu.tbadk.core.a.h.n(4, personPrivate.AD());
                        com.baidu.tbadk.core.a.h.n(2, personPrivate.AB());
                    }
                }
            }
        }
    }
}
