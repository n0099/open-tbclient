package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ w dDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.dDs = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dDs.ex(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("enter_forum_edit_mode", false);
        TiebaStatic.log("c10099");
    }
}
