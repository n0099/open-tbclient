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
    final /* synthetic */ IMBlackListActivity dsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.dsi = iMBlackListActivity;
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
        hVar = this.dsi.dsg;
        hVar.awX();
        this.dsi.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar3 = this.dsi.KN;
                    if (aVar3 != null) {
                        aVar4 = this.dsi.KN;
                        aVar4.dismiss();
                    }
                    hVar3 = this.dsi.dsg;
                    hVar3.T(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.dsi.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.dsi.getResources().getString(w.l.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.i.hj()) {
                    hVar4 = this.dsi.dsg;
                    hVar4.refreshData();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.dsi.KN;
                    if (aVar != null) {
                        aVar2 = this.dsi.KN;
                        aVar2.dismiss();
                    }
                    this.dsi.showToast(this.dsi.getPageContext().getString(w.l.black_list_remove_success));
                    blackListItemData = this.dsi.dsh;
                    if (blackListItemData != null) {
                        hVar2 = this.dsi.dsg;
                        blackListItemData2 = this.dsi.dsh;
                        hVar2.b(blackListItemData2);
                        this.dsi.dsh = null;
                        return;
                    }
                    return;
                }
                this.dsi.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
