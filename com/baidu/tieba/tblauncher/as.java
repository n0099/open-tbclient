package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ai cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ai aiVar) {
        this.cMQ = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cMQ.fI(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CONFIRM));
        com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("enter_forum_edit_mode", false);
        TiebaStatic.log("c10099");
    }
}
