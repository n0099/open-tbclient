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
public class bk extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(f fVar, int i, int i2) {
        super(i, i2);
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        com.baidu.tbadk.data.j personPrivate;
        bp bpVar5;
        BlackListModel blackListModel;
        bp bpVar6;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar;
        bs bsVar;
        FrameLayout frameLayout;
        bs bsVar2;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        bp bpVar7;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        bs bsVar3;
        FrameLayout frameLayout4;
        bs bsVar4;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        bp bpVar8;
        com.baidu.tieba.tbadkCore.d.b bVar4;
        bp bpVar9;
        bp bpVar10;
        if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
            if (responsedMessage.getOrginalMessage() != null) {
                bpVar9 = this.this$0.eht;
                if (bpVar9.getUniqueId() != null) {
                    bpVar10 = this.this$0.eht;
                    if (bpVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                bVar3 = this.this$0.btR;
                if (bVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    bVar4 = this.this$0.btR;
                    bVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.this$0.btR = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    responsedMessage.getOrginalMessage();
                    bpVar8 = this.this$0.eht;
                    bpVar8.a(profileSocketResponseMessage);
                } else {
                    this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(u.j.neterror) : responsedMessage.getErrorString());
                    bsVar3 = this.this$0.eoE;
                    if (bsVar3 != null) {
                        frameLayout4 = this.this$0.eoL;
                        if (frameLayout4 != null) {
                            bsVar4 = this.this$0.eoE;
                            bsVar4.US();
                            f fVar = this.this$0;
                            frameLayout5 = this.this$0.eoL;
                            fVar.aw(frameLayout5);
                            f fVar2 = this.this$0;
                            frameLayout6 = this.this$0.eoL;
                            fVar2.showNetRefreshView(frameLayout6, this.this$0.getPageContext().getResources().getString(u.j.neterror), false);
                        }
                    }
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                bVar = this.this$0.btR;
                if (bVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    bVar2 = this.this$0.btR;
                    bVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.this$0.btR = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    bpVar7 = this.this$0.eht;
                    bpVar7.a(profileHttpResponseMessage);
                } else {
                    this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(u.j.neterror) : responsedMessage.getErrorString());
                    bsVar = this.this$0.eoE;
                    if (bsVar != null) {
                        frameLayout = this.this$0.eoL;
                        if (frameLayout != null) {
                            bsVar2 = this.this$0.eoE;
                            bsVar2.US();
                            f fVar3 = this.this$0;
                            frameLayout2 = this.this$0.eoL;
                            fVar3.aw(frameLayout2);
                            f fVar4 = this.this$0;
                            frameLayout3 = this.this$0.eoL;
                            fVar4.showNetRefreshView(frameLayout3, this.this$0.getPageContext().getResources().getString(u.j.neterror), false);
                        }
                    }
                }
            }
            bpVar = this.this$0.eht;
            if (bpVar != null) {
                bpVar5 = this.this$0.eht;
                if (bpVar5.getUserData() != null) {
                    blackListModel = this.this$0.eoF;
                    bpVar6 = this.this$0.eht;
                    if (bpVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            bpVar2 = this.this$0.eht;
            if (bpVar2 != null) {
                bpVar3 = this.this$0.eht;
                if (bpVar3.getIsSelf()) {
                    bpVar4 = this.this$0.eht;
                    UserData userData = bpVar4.getUserData();
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
