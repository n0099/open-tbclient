package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity diy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.diy = iMBlackListActivity;
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
        hVar = this.diy.diw;
        hVar.aux();
        this.diy.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar3 = this.diy.LG;
                    if (aVar3 != null) {
                        aVar4 = this.diy.LG;
                        aVar4.dismiss();
                    }
                    hVar3 = this.diy.diw;
                    hVar3.S(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.diy.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.diy.getResources().getString(w.l.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.hj()) {
                    hVar4 = this.diy.diw;
                    hVar4.refreshData();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.diy.LG;
                    if (aVar != null) {
                        aVar2 = this.diy.LG;
                        aVar2.dismiss();
                    }
                    this.diy.showToast(this.diy.getPageContext().getString(w.l.black_list_remove_success));
                    blackListItemData = this.diy.dix;
                    if (blackListItemData != null) {
                        hVar2 = this.diy.diw;
                        blackListItemData2 = this.diy.dix;
                        hVar2.b(blackListItemData2);
                        this.diy.dix = null;
                        return;
                    }
                    return;
                }
                this.diy.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
