package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ aa etY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(aa aaVar) {
        this.etY = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("enter_forum_edit_mode", false);
    }
}
