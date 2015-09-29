package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.diB = userMuteAddAndDelModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tbadk.core.view.a aVar;
        com.baidu.tbadk.core.view.f fVar;
        BaseActivity baseActivity;
        com.baidu.tbadk.core.view.f fVar2;
        BaseActivity baseActivity2;
        String str;
        UserMuteAddAndDelModel.b bVar;
        UserMuteAddAndDelModel.b bVar2;
        aVar = this.diB.aLD;
        aVar.av(false);
        if (httpResponsedMessage instanceof UserMuteDelResponseMessage) {
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
            if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                fVar2 = this.diB.diw;
                baseActivity2 = this.diB.aRT;
                fVar2.dA(baseActivity2.getResources().getString(i.h.un_mute_success));
                MessageManager messageManager = MessageManager.getInstance();
                str = this.diB.mUserId;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM, str));
                bVar = this.diB.csw;
                if (bVar != null) {
                    bVar2 = this.diB.csw;
                    bVar2.a(userMuteDelResponseMessage);
                    return;
                }
                return;
            }
            String muteMessage = userMuteDelResponseMessage.getMuteMessage();
            if (ar.isEmpty(muteMessage)) {
                baseActivity = this.diB.aRT;
                muteMessage = baseActivity.getResources().getString(i.h.un_mute_fail);
            }
            fVar = this.diB.diw;
            fVar.dB(muteMessage);
        }
    }
}
