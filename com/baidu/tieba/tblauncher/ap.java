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
public class ap implements View.OnClickListener {
    final /* synthetic */ aa etY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(aa aaVar) {
        this.etY = aaVar;
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
        this.etY.iV(false);
        imageView = this.etY.etS;
        imageView.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("game_is_show_tip", false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
        mainTabActivity = this.etY.etM;
        mainTabActivity2 = this.etY.etM;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
        mainTabActivity3 = this.etY.etM;
        TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
        mainTabActivity4 = this.etY.etM;
        mainTabActivity5 = this.etY.etM;
        mainTabActivity4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(mainTabActivity5.getPageContext().getPageActivity())));
        mainTabActivity6 = this.etY.etM;
        TiebaStatic.eventStat(mainTabActivity6.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
    }
}
