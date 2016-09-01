package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ ac fwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ac acVar) {
        this.fwR = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("enter_forum_edit_mode", false);
    }
}
