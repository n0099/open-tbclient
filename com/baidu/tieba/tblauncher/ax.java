package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ ak fHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ak akVar) {
        this.fHb = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.fHb.lD(false);
        imageView = this.fHb.fGT;
        imageView.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.fHb.fGR;
        messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, mainTabActivity.getPageContext()));
        mainTabActivity2 = this.fHb.fGR;
        TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
    }
}
