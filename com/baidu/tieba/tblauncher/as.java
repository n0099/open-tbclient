package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ ao ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar) {
        this.ddy = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        MainTabActivity mainTabActivity4;
        MainTabActivity mainTabActivity5;
        MainTabActivity mainTabActivity6;
        imageView = this.ddy.ddr;
        imageView.setVisibility(4);
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("game_is_show_tip", false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
        mainTabActivity = this.ddy.ddt;
        mainTabActivity2 = this.ddy.ddt;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
        mainTabActivity3 = this.ddy.ddt;
        TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
        mainTabActivity4 = this.ddy.ddt;
        mainTabActivity5 = this.ddy.ddt;
        mainTabActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(mainTabActivity5.getPageContext().getPageActivity())));
        mainTabActivity6 = this.ddy.ddt;
        TiebaStatic.eventStat(mainTabActivity6.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
    }
}
