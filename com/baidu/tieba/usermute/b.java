package com.baidu.tieba.usermute;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel dkH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.dkH = userMuteAddAndDelModel;
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
        aVar = this.dkH.aLW;
        aVar.av(false);
        if (httpResponsedMessage instanceof UserMuteDelResponseMessage) {
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) httpResponsedMessage;
            if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                fVar2 = this.dkH.dkC;
                baseActivity2 = this.dkH.aSm;
                fVar2.dA(baseActivity2.getResources().getString(i.h.un_mute_success));
                MessageManager messageManager = MessageManager.getInstance();
                str = this.dkH.mUserId;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM, str));
                bVar = this.dkH.cud;
                if (bVar != null) {
                    bVar2 = this.dkH.cud;
                    bVar2.a(userMuteDelResponseMessage);
                    return;
                }
                return;
            }
            String muteMessage = userMuteDelResponseMessage.getMuteMessage();
            if (as.isEmpty(muteMessage)) {
                baseActivity = this.dkH.aSm;
                muteMessage = baseActivity.getResources().getString(i.h.un_mute_fail);
            }
            fVar = this.dkH.dkC;
            fVar.dB(muteMessage);
        }
    }
}
