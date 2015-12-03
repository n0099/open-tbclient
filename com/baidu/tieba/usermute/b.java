package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel dIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.dIS = userMuteAddAndDelModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tbadk.core.view.b bVar;
        com.baidu.tbadk.core.view.g gVar;
        com.baidu.adp.base.h hVar;
        com.baidu.tbadk.core.view.g gVar2;
        com.baidu.adp.base.h hVar2;
        String str;
        UserMuteAddAndDelModel.b bVar2;
        UserMuteAddAndDelModel.b bVar3;
        bVar = this.dIS.aQC;
        bVar.ay(false);
        if (httpResponsedMessage instanceof UserMuteDelResponseMessage) {
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
            if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                gVar2 = this.dIS.dIN;
                hVar2 = this.dIS.dIK;
                gVar2.d(hVar2.getResources().getString(n.i.un_mute_success));
                MessageManager messageManager = MessageManager.getInstance();
                str = this.dIS.mUserId;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM, str));
                bVar2 = this.dIS.cSg;
                if (bVar2 != null) {
                    bVar3 = this.dIS.cSg;
                    bVar3.a(userMuteDelResponseMessage);
                    return;
                }
                return;
            }
            String muteMessage = userMuteDelResponseMessage.getMuteMessage();
            if (ax.isEmpty(muteMessage)) {
                hVar = this.dIS.dIK;
                muteMessage = hVar.getResources().getString(n.i.un_mute_fail);
            }
            gVar = this.dIS.dIN;
            gVar.e(muteMessage);
        }
    }
}
