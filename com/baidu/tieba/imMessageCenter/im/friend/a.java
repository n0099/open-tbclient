package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.bvg = iMBlackListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        i iVar;
        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
        Message<?> orginalMessage;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tieba.im.data.a aVar2;
        i iVar2;
        com.baidu.tieba.im.data.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        i iVar3;
        com.baidu.tbadk.core.dialog.a aVar6;
        i iVar4;
        iVar = this.bvg.bve;
        iVar.WR();
        this.bvg.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar5 = this.bvg.Ll;
                    if (aVar5 != null) {
                        aVar6 = this.bvg.Ll;
                        aVar6.dismiss();
                    }
                    iVar3 = this.bvg.bve;
                    iVar3.A(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.bvg.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.bvg.getResources().getString(com.baidu.tieba.t.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.k.iX()) {
                    iVar4 = this.bvg.bve;
                    iVar4.WS();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.bvg.Ll;
                    if (aVar != null) {
                        aVar4 = this.bvg.Ll;
                        aVar4.dismiss();
                    }
                    this.bvg.showToast(this.bvg.getPageContext().getString(com.baidu.tieba.t.black_list_remove_success));
                    aVar2 = this.bvg.bvf;
                    if (aVar2 != null) {
                        iVar2 = this.bvg.bve;
                        aVar3 = this.bvg.bvf;
                        iVar2.b(aVar3);
                        this.bvg.bvf = null;
                        return;
                    }
                    return;
                }
                this.bvg.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
