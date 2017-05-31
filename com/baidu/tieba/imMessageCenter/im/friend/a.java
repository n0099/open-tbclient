package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity dkm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.dkm = iMBlackListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        h hVar;
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tbadk.core.dialog.a aVar;
        BlackListItemData blackListItemData;
        h hVar2;
        BlackListItemData blackListItemData2;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        h hVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        h hVar4;
        hVar = this.dkm.dkk;
        hVar.atp();
        this.dkm.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar3 = this.dkm.KO;
                    if (aVar3 != null) {
                        aVar4 = this.dkm.KO;
                        aVar4.dismiss();
                    }
                    hVar3 = this.dkm.dkk;
                    hVar3.R(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.dkm.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.dkm.getResources().getString(w.l.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.hk()) {
                    hVar4 = this.dkm.dkk;
                    hVar4.refreshData();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.dkm.KO;
                    if (aVar != null) {
                        aVar2 = this.dkm.KO;
                        aVar2.dismiss();
                    }
                    this.dkm.showToast(this.dkm.getPageContext().getString(w.l.black_list_remove_success));
                    blackListItemData = this.dkm.dkl;
                    if (blackListItemData != null) {
                        hVar2 = this.dkm.dkk;
                        blackListItemData2 = this.dkm.dkl;
                        hVar2.b(blackListItemData2);
                        this.dkm.dkl = null;
                        return;
                    }
                    return;
                }
                this.dkm.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
