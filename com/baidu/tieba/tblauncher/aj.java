package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ ac fwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ac acVar) {
        this.fwR = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fwR.ho(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("enter_forum_edit_mode", false);
        TiebaStatic.log("c10099");
    }
}
