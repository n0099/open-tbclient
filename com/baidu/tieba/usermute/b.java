package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel eld;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.eld = userMuteAddAndDelModel;
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
        bVar = this.eld.aWB;
        bVar.aw(false);
        if (httpResponsedMessage instanceof UserMuteDelResponseMessage) {
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
            if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                hVar3 = this.eld.ekY;
                hVar4 = this.eld.ekV;
                hVar3.c(hVar4.getResources().getString(t.j.un_mute_success));
                MessageManager messageManager = MessageManager.getInstance();
                str = this.eld.mUserId;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM, str));
                bVar2 = this.eld.diw;
                if (bVar2 != null) {
                    bVar3 = this.eld.diw;
                    bVar3.a(userMuteDelResponseMessage);
                    return;
                }
                return;
            }
            String muteMessage = userMuteDelResponseMessage.getMuteMessage();
            if (aw.isEmpty(muteMessage)) {
                hVar2 = this.eld.ekV;
                muteMessage = hVar2.getResources().getString(t.j.un_mute_fail);
            }
            hVar = this.eld.ekY;
            hVar.d(muteMessage);
        }
    }
}
