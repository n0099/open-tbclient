package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity das;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.das = iMBlackListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        h hVar;
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tieba.im.data.a aVar2;
        h hVar2;
        com.baidu.tieba.im.data.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        h hVar3;
        com.baidu.tbadk.core.dialog.a aVar6;
        h hVar4;
        hVar = this.das.daq;
        hVar.aud();
        this.das.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar5 = this.das.FG;
                    if (aVar5 != null) {
                        aVar6 = this.das.FG;
                        aVar6.dismiss();
                    }
                    hVar3 = this.das.daq;
                    hVar3.Q(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.das.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.das.getResources().getString(r.j.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.gm()) {
                    hVar4 = this.das.daq;
                    hVar4.refreshData();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.das.FG;
                    if (aVar != null) {
                        aVar4 = this.das.FG;
                        aVar4.dismiss();
                    }
                    this.das.showToast(this.das.getPageContext().getString(r.j.black_list_remove_success));
                    aVar2 = this.das.dar;
                    if (aVar2 != null) {
                        hVar2 = this.das.daq;
                        aVar3 = this.das.dar;
                        hVar2.b(aVar3);
                        this.das.dar = null;
                        return;
                    }
                    return;
                }
                this.das.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
