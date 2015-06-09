package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ IMBlackListActivity bvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(IMBlackListActivity iMBlackListActivity, int i) {
        super(i);
        this.bvh = iMBlackListActivity;
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
        iVar = this.bvh.bvf;
        iVar.WS();
        this.bvh.closeLoadingDialog();
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                if (responseGetMaskInfoMessage.getError() == 0) {
                    aVar5 = this.bvh.Ll;
                    if (aVar5 != null) {
                        aVar6 = this.bvh.Ll;
                        aVar6.dismiss();
                    }
                    iVar3 = this.bvh.bvf;
                    iVar3.A(responseGetMaskInfoMessage.getBlackList());
                    return;
                }
                this.bvh.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.bvh.getResources().getString(com.baidu.tieba.t.neterror) : responseGetMaskInfoMessage.getErrorString());
                if (com.baidu.adp.lib.util.k.iX()) {
                    iVar4 = this.bvh.bvf;
                    iVar4.WT();
                }
            } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                if (responseUpdateMaskInfoMessage.getError() == 0) {
                    aVar = this.bvh.Ll;
                    if (aVar != null) {
                        aVar4 = this.bvh.Ll;
                        aVar4.dismiss();
                    }
                    this.bvh.showToast(this.bvh.getPageContext().getString(com.baidu.tieba.t.black_list_remove_success));
                    aVar2 = this.bvh.bvg;
                    if (aVar2 != null) {
                        iVar2 = this.bvh.bvf;
                        aVar3 = this.bvh.bvg;
                        iVar2.b(aVar3);
                        this.bvh.bvg = null;
                        return;
                    }
                    return;
                }
                this.bvh.showToast(responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }
}
