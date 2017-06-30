package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ ad fQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ad adVar) {
        this.fQS = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.fQS.mc(false);
        imageView = this.fQS.fQK;
        imageView.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.fQS.fQI;
        messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, mainTabActivity.getPageContext()));
        mainTabActivity2 = this.fQS.fQI;
        TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
    }
}
