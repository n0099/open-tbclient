package com.baidu.tieba.pb.pb.sub;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.euQ = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        ao aoVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        com.baidu.tbadk.core.view.h hVar2;
        com.baidu.adp.base.g gVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.euQ.euL;
            if (tag == bdUniqueId) {
                aoVar = this.euQ.euB;
                aoVar.aIn();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar2 = this.euQ.elc;
                    gVar3 = this.euQ.elb;
                    hVar2.c(gVar3.getResources().getString(w.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        gVar2 = this.euQ.elb;
                        errorString = gVar2.getResources().getString(w.l.mute_error_beyond_limit);
                    }
                    this.euQ.fx(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.au.isEmpty(errorString2)) {
                        gVar = this.euQ.elb;
                        errorString2 = gVar.getResources().getString(w.l.mute_fail);
                    }
                    hVar = this.euQ.elc;
                    hVar.d(errorString2);
                } else {
                    this.euQ.aKN();
                }
            }
        }
    }
}
