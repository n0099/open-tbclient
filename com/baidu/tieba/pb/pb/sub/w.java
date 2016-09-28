package com.baidu.tieba.pb.pb.sub;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.exF = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        ag agVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.tbadk.core.view.h hVar4;
        com.baidu.adp.base.h hVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.exF.exD;
            if (tag == bdUniqueId) {
                agVar = this.exF.exu;
                agVar.aLg();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar4 = this.exF.ept;
                    hVar5 = this.exF.eps;
                    hVar4.c(hVar5.getResources().getString(r.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        hVar3 = this.exF.eps;
                        errorString = hVar3.getResources().getString(r.j.mute_error_beyond_limit);
                    }
                    this.exF.fM(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (az.isEmpty(errorString2)) {
                        hVar2 = this.exF.eps;
                        errorString2 = hVar2.getResources().getString(r.j.mute_fail);
                    }
                    hVar = this.exF.ept;
                    hVar.d(errorString2);
                } else {
                    this.exF.aNP();
                }
            }
        }
    }
}
