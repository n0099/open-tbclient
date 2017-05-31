package com.baidu.tieba.wxapi;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class e extends AuthorizationListener {
    final /* synthetic */ WXEntryActivity gci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.gci = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        bk bkVar = new bk();
        bkVar.Xm = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, bkVar));
        this.gci.closeActivity();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        bk bkVar = new bk();
        bkVar.Xm = 2;
        bkVar.errorCode = i;
        bkVar.errorMsg = str;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, bkVar));
        this.gci.closeActivity();
    }
}
