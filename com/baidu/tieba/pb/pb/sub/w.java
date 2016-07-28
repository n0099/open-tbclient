package com.baidu.tieba.pb.pb.sub;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.ejr = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        af afVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.tbadk.core.view.h hVar4;
        com.baidu.adp.base.h hVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.ejr.ejp;
            if (tag == bdUniqueId) {
                afVar = this.ejr.ejg;
                afVar.aFN();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar4 = this.ejr.ebo;
                    hVar5 = this.ejr.ebn;
                    hVar4.c(hVar5.getResources().getString(u.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        hVar3 = this.ejr.ebn;
                        errorString = hVar3.getResources().getString(u.j.mute_error_beyond_limit);
                    }
                    this.ejr.fF(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ba.isEmpty(errorString2)) {
                        hVar2 = this.ejr.ebn;
                        errorString2 = hVar2.getResources().getString(u.j.mute_fail);
                    }
                    hVar = this.ejr.ebo;
                    hVar.d(errorString2);
                } else {
                    this.ejr.aIr();
                }
            }
        }
    }
}
