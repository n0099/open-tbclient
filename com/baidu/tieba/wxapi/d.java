package com.baidu.tieba.wxapi;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d extends AuthorizationListener {
    final /* synthetic */ WXEntryActivity dsL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WXEntryActivity wXEntryActivity) {
        this.dsL = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onSuccess() {
        v vVar = new v();
        vVar.Vv = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, vVar));
        this.dsL.closeActivity();
    }

    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
    public void onFailed(int i, String str) {
        v vVar = new v();
        vVar.Vv = 2;
        vVar.errorCode = i;
        vVar.errorMsg = str;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LOGIN_WEINXIN, vVar));
        this.dsL.closeActivity();
    }
}
