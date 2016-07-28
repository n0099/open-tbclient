package com.baidu.tieba.personInfo;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(h hVar, int i) {
        super(i);
        this.this$0 = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        com.baidu.tbadk.core.view.b bVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.tbadk.core.view.h hVar3;
        com.baidu.adp.base.h hVar4;
        com.baidu.tbadk.core.view.b bVar2;
        if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.this$0.eAN;
            if (tag == bdUniqueId) {
                bVar = this.this$0.bvD;
                if (bVar != null) {
                    bVar2 = this.this$0.bvD;
                    bVar2.aE(false);
                }
                this.this$0.eAG = 0;
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    hVar3 = this.this$0.ebo;
                    hVar4 = this.this$0.ebn;
                    hVar3.c(hVar4.getResources().getString(u.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ba.isEmpty(muteMessage)) {
                    hVar2 = this.this$0.ebn;
                    muteMessage = hVar2.getResources().getString(u.j.un_mute_fail);
                }
                hVar = this.this$0.ebo;
                hVar.d(muteMessage);
            }
        }
    }
}
