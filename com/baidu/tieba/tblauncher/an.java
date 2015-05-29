package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar) {
        this.cwn = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        imageView = this.cwn.cwf;
        imageView.setVisibility(4);
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("game_is_show_tip", false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
        mainTabActivity = this.cwn.cwh;
        mainTabActivity2 = this.cwn.cwh;
        mainTabActivity.sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
        mainTabActivity3 = this.cwn.cwh;
        TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
    }
}
