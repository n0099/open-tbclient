package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ aa etY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(aa aaVar) {
        this.etY = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.etY.fx(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("enter_forum_edit_mode", false);
        TiebaStatic.log("c10099");
    }
}
