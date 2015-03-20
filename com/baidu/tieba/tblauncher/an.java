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
    final /* synthetic */ ai crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ai aiVar) {
        this.crN = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        imageView = this.crN.crG;
        imageView.setVisibility(4);
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("game_is_show_tip", false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
        mainTabActivity = this.crN.crH;
        mainTabActivity2 = this.crN.crH;
        mainTabActivity.sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
        mainTabActivity3 = this.crN.crH;
        TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "tb_gamecenter", "click", 1, "ref_type", "601");
    }
}
