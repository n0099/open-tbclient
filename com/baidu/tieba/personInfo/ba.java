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
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(f fVar, int i, int i2) {
        super(i, i2);
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        com.baidu.tbadk.data.g personPrivate;
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
                bfVar9 = this.this$0.dvN;
                if (bfVar9.getUniqueId() != null) {
                    bfVar10 = this.this$0.dvN;
                    if (bfVar10.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                        return;
                    }
                }
            }
            if (responsedMessage instanceof ProfileSocketResponseMessage) {
                ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                bVar3 = this.this$0.bbO;
                if (bVar3 != null) {
                    long downSize = profileSocketResponseMessage.getDownSize();
                    long costTime = profileSocketResponseMessage.getCostTime();
                    bVar4 = this.this$0.bbO;
                    bVar4.a(false, !responsedMessage.hasError(), profileSocketResponseMessage.getError(), profileSocketResponseMessage.getErrorString(), downSize, 0L, costTime);
                    this.this$0.bbO = null;
                }
                if (profileSocketResponseMessage.getError() == 0) {
                    responsedMessage.getOrginalMessage();
                    bfVar8 = this.this$0.dvN;
                    bfVar8.a(profileSocketResponseMessage);
                } else {
                    this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
                    biVar3 = this.this$0.dCt;
                    if (biVar3 != null) {
                        frameLayout4 = this.this$0.dCA;
                        if (frameLayout4 != null) {
                            biVar4 = this.this$0.dCt;
                            biVar4.Qo();
                            f fVar = this.this$0;
                            frameLayout5 = this.this$0.dCA;
                            fVar.aD(frameLayout5);
                            f fVar2 = this.this$0;
                            frameLayout6 = this.this$0.dCA;
                            fVar2.showNetRefreshView(frameLayout6, this.this$0.getPageContext().getResources().getString(t.j.neterror), false);
                        }
                    }
                }
            }
            if (responsedMessage instanceof ProfileHttpResponseMessage) {
                ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                bVar = this.this$0.bbO;
                if (bVar != null) {
                    long downSize2 = profileHttpResponseMessage.getDownSize();
                    long costTime2 = profileHttpResponseMessage.getCostTime();
                    bVar2 = this.this$0.bbO;
                    bVar2.a(true, !responsedMessage.hasError(), profileHttpResponseMessage.getError(), profileHttpResponseMessage.getErrorString(), downSize2, costTime2, 0L);
                    this.this$0.bbO = null;
                }
                if (profileHttpResponseMessage.getError() == 0) {
                    bfVar7 = this.this$0.dvN;
                    bfVar7.a(profileHttpResponseMessage);
                } else {
                    this.this$0.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(t.j.neterror) : responsedMessage.getErrorString());
                    biVar = this.this$0.dCt;
                    if (biVar != null) {
                        frameLayout = this.this$0.dCA;
                        if (frameLayout != null) {
                            biVar2 = this.this$0.dCt;
                            biVar2.Qo();
                            f fVar3 = this.this$0;
                            frameLayout2 = this.this$0.dCA;
                            fVar3.aD(frameLayout2);
                            f fVar4 = this.this$0;
                            frameLayout3 = this.this$0.dCA;
                            fVar4.showNetRefreshView(frameLayout3, this.this$0.getPageContext().getResources().getString(t.j.neterror), false);
                        }
                    }
                }
            }
            bfVar = this.this$0.dvN;
            if (bfVar != null) {
                bfVar5 = this.this$0.dvN;
                if (bfVar5.getUserData() != null) {
                    blackListModel = this.this$0.dCu;
                    bfVar6 = this.this$0.dvN;
                    if (bfVar6.getUserData().isMask()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    blackListModel.setMaskType(i);
                }
            }
            bfVar2 = this.this$0.dvN;
            if (bfVar2 != null) {
                bfVar3 = this.this$0.dvN;
                if (bfVar3.getIsSelf()) {
                    bfVar4 = this.this$0.dvN;
                    UserData userData = bfVar4.getUserData();
                    if (userData != null && (personPrivate = userData.getPersonPrivate()) != null) {
                        com.baidu.tbadk.core.a.h.n(5, personPrivate.CK());
                        com.baidu.tbadk.core.a.h.n(3, personPrivate.CI());
                        com.baidu.tbadk.core.a.h.n(4, personPrivate.CJ());
                        com.baidu.tbadk.core.a.h.n(2, personPrivate.CH());
                    }
                }
            }
        }
    }
}
