package com.baidu.tieba.pb.pb.sub;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.erC = newSubPbActivity;
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
            bdUniqueId = this.erC.erx;
            if (tag == bdUniqueId) {
                aoVar = this.erC.ern;
                aoVar.aIO();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar2 = this.erC.eil;
                    gVar3 = this.erC.eik;
                    hVar2.c(gVar3.getResources().getString(r.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        gVar2 = this.erC.eik;
                        errorString = gVar2.getResources().getString(r.l.mute_error_beyond_limit);
                    }
                    this.erC.fI(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        gVar = this.erC.eik;
                        errorString2 = gVar.getResources().getString(r.l.mute_fail);
                    }
                    hVar = this.erC.eil;
                    hVar.d(errorString2);
                } else {
                    this.erC.aLs();
                }
            }
        }
    }
}
