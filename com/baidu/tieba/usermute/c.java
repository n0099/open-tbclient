package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel eVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.eVj = userMuteAddAndDelModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tbadk.core.view.b bVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.tbadk.core.view.h hVar3;
        com.baidu.adp.base.h hVar4;
        String str;
        UserMuteAddAndDelModel.b bVar2;
        UserMuteAddAndDelModel.b bVar3;
        bVar = this.eVj.aXt;
        bVar.aD(false);
        if (httpResponsedMessage instanceof UserMuteDelResponseMessage) {
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
            if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                hVar3 = this.eVj.eVe;
                hVar4 = this.eVj.eVb;
                hVar3.c(hVar4.getResources().getString(t.j.un_mute_success));
                MessageManager messageManager = MessageManager.getInstance();
                str = this.eVj.mUserId;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM, str));
                bVar2 = this.eVj.dGf;
                if (bVar2 != null) {
                    bVar3 = this.eVj.dGf;
                    bVar3.a(userMuteDelResponseMessage);
                    return;
                }
                return;
            }
            String muteMessage = userMuteDelResponseMessage.getMuteMessage();
            if (ay.isEmpty(muteMessage)) {
                hVar2 = this.eVj.eVb;
                muteMessage = hVar2.getResources().getString(t.j.un_mute_fail);
            }
            hVar = this.eVj.eVe;
            hVar.d(muteMessage);
        }
    }
}
