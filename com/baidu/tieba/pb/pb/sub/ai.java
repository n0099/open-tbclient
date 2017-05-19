package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.eqU = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        ao aoVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.g gVar;
        com.baidu.tbadk.core.view.h hVar2;
        com.baidu.adp.base.g gVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.eqU.eqP;
            if (tag == bdUniqueId) {
                aoVar = this.eqU.eqF;
                aoVar.aGA();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    hVar2 = this.eqU.egK;
                    gVar2 = this.eqU.egJ;
                    hVar2.c(gVar2.getResources().getString(w.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.au.isEmpty(muteMessage)) {
                    gVar = this.eqU.egJ;
                    muteMessage = gVar.getResources().getString(w.l.un_mute_fail);
                }
                hVar = this.eqU.egK;
                hVar.d(muteMessage);
            }
        }
    }
}
