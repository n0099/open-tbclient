package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.dWP = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        af afVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.tbadk.core.view.h hVar3;
        com.baidu.adp.base.h hVar4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.dWP.dWN;
            if (tag == bdUniqueId) {
                afVar = this.dWP.dWE;
                afVar.aHL();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    hVar3 = this.dWP.dPb;
                    hVar4 = this.dWP.dPa;
                    hVar3.c(hVar4.getResources().getString(u.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ba.isEmpty(muteMessage)) {
                    hVar2 = this.dWP.dPa;
                    muteMessage = hVar2.getResources().getString(u.j.un_mute_fail);
                }
                hVar = this.dWP.dPb;
                hVar.d(muteMessage);
            }
        }
    }
}
