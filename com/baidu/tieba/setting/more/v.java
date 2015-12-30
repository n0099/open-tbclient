package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ u duD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.duD = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MoreActivity moreActivity;
        MoreActivity moreActivity2;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
        TbadkCoreApplication.m411getInst().deleteAccountAllInfo(currentAccount);
        moreActivity = this.duD.this$0;
        TbadkCoreApplication.setCurrentAccount(null, moreActivity.getPageContext().getPageActivity());
        com.baidu.tbadk.coreExtra.a.a.wy().wA();
        TbadkCoreApplication.m411getInst().onUserChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_MATINTAB, null));
        moreActivity2 = this.duD.this$0;
        moreActivity2.finish();
    }
}
