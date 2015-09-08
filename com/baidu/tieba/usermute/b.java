package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel cXA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.cXA = userMuteAddAndDelModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tbadk.core.view.a aVar;
        n nVar;
        BaseActivity baseActivity;
        n nVar2;
        BaseActivity baseActivity2;
        String str;
        UserMuteAddAndDelModel.b bVar;
        UserMuteAddAndDelModel.b bVar2;
        aVar = this.cXA.aMI;
        aVar.av(false);
        if (httpResponsedMessage instanceof UserMuteDelResponseMessage) {
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
            if (userMuteDelResponseMessage.getMuteErrorCode() == UserMuteAddAndDelModel.cXs) {
                nVar2 = this.cXA.cXv;
                baseActivity2 = this.cXA.aSX;
                nVar2.dw(baseActivity2.getResources().getString(i.h.un_mute_success));
                MessageManager messageManager = MessageManager.getInstance();
                str = this.cXA.mUserId;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM, str));
                bVar = this.cXA.cmQ;
                if (bVar != null) {
                    bVar2 = this.cXA.cmQ;
                    bVar2.a(userMuteDelResponseMessage);
                    return;
                }
                return;
            }
            String muteMessage = userMuteDelResponseMessage.getMuteMessage();
            if (aq.isEmpty(muteMessage)) {
                baseActivity = this.cXA.aSX;
                muteMessage = baseActivity.getResources().getString(i.h.un_mute_fail);
            }
            nVar = this.cXA.cXv;
            nVar.dx(muteMessage);
        }
    }
}
