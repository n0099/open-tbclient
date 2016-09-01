package com.baidu.tieba.pb.pb.sub;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.evy = newSubPbActivity;
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
            bdUniqueId = this.evy.evw;
            if (tag == bdUniqueId) {
                agVar = this.evy.evn;
                agVar.aKF();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar4 = this.evy.enw;
                    hVar5 = this.evy.env;
                    hVar4.c(hVar5.getResources().getString(t.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        hVar3 = this.evy.env;
                        errorString = hVar3.getResources().getString(t.j.mute_error_beyond_limit);
                    }
                    this.evy.fI(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ba.isEmpty(errorString2)) {
                        hVar2 = this.evy.env;
                        errorString2 = hVar2.getResources().getString(t.j.mute_fail);
                    }
                    hVar = this.evy.enw;
                    hVar.d(errorString2);
                } else {
                    this.evy.aNj();
                }
            }
        }
    }
}
