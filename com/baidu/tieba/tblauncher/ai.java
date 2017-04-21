package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ z fCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.fCF = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.fCF.fd(false);
        imageView = this.fCF.cyn;
        imageView.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("game_is_show_tip", false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.fCF.fCy;
        messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, mainTabActivity.getPageContext()));
        mainTabActivity2 = this.fCF.fCy;
        TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
    }
}
