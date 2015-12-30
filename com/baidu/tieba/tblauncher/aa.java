package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ w dKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.dKW = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dKW.ex(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
        com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("enter_forum_edit_mode", false);
        TiebaStatic.log("c10099");
    }
}
