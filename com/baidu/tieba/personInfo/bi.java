package com.baidu.tieba.personInfo;

import android.widget.FrameLayout;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(h hVar, int i, int i2) {
        super(i, i2);
        this.this$0 = hVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        com.baidu.tbadk.data.j personPrivate;
        bn bnVar5;
        BlackListModel blackListModel;
        bn bnVar6;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar;
        bq bqVar;
        FrameLayout frameLayout;
        bq bqVar2;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        bn bnVar7;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        bq bqVar3;
        FrameLayout frameLayout4;
        bq bqVar4;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        bn bnVar8;
        com.baidu.tieba.tbadkCore.d.b bVar4;
        bn bnVar9;
        bn bnVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                bnVar9 = this.this$0.ers;
                if (bnVar9.getUniqueId() != null) {
                    bnVar10 = this.this$0.ers;
                    if (bnVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                bVar3 = this.this$0.bwf;
                if (bVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    bVar4 = this.this$0.bwf;
                    bVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.this$0.bwf = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    responsedMessage.getOrginalMessage();
                    bnVar8 = this.this$0.ers;
                    bnVar8.a(profileSocketResponseMessage);
                } else {
                    this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(u.j.neterror) : responsedMessage.getErrorString());
                    bqVar3 = this.this$0.eAu;
                    if (bqVar3 != null) {
                        frameLayout4 = this.this$0.eAB;
                        if (frameLayout4 != null) {
                            bqVar4 = this.this$0.eAu;
                            bqVar4.aap();
                            h hVar = this.this$0;
                            frameLayout5 = this.this$0.eAB;
                            hVar.au(frameLayout5);
                            h hVar2 = this.this$0;
                            frameLayout6 = this.this$0.eAB;
                            hVar2.showNetRefreshView(frameLayout6, this.this$0.getPageContext().getResources().getString(u.j.neterror), false);
                        }
                    }
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                bVar = this.this$0.bwf;
                if (bVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    bVar2 = this.this$0.bwf;
                    bVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.this$0.bwf = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    bnVar7 = this.this$0.ers;
                    bnVar7.a(profileHttpResponseMessage);
                } else {
                    this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(u.j.neterror) : responsedMessage.getErrorString());
                    bqVar = this.this$0.eAu;
                    if (bqVar != null) {
                        frameLayout = this.this$0.eAB;
                        if (frameLayout != null) {
                            bqVar2 = this.this$0.eAu;
                            bqVar2.aap();
                            h hVar3 = this.this$0;
                            frameLayout2 = this.this$0.eAB;
                            hVar3.au(frameLayout2);
                            h hVar4 = this.this$0;
                            frameLayout3 = this.this$0.eAB;
                            hVar4.showNetRefreshView(frameLayout3, this.this$0.getPageContext().getResources().getString(u.j.neterror), false);
                        }
                    }
                }
            }
            bnVar = this.this$0.ers;
            if (bnVar != null) {
                bnVar5 = this.this$0.ers;
                if (bnVar5.getUserData() != null) {
                    blackListModel = this.this$0.eAv;
                    bnVar6 = this.this$0.ers;
                    if (bnVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            bnVar2 = this.this$0.ers;
            if (bnVar2 != null) {
                bnVar3 = this.this$0.ers;
                if (bnVar3.getIsSelf()) {
                    bnVar4 = this.this$0.ers;
                    UserData userData = bnVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.h.n(5, personPrivate.AO());
                        com.baidu.tbadk.core.a.h.n(3, personPrivate.AM());
                        com.baidu.tbadk.core.a.h.n(4, personPrivate.AN());
                        com.baidu.tbadk.core.a.h.n(2, personPrivate.AL());
                    }
                }
            }
        }
    }
}
