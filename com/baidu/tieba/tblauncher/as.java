package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ an ccc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(an anVar) {
        this.ccc = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        imageView = this.ccc.cbV;
        imageView.setVisibility(4);
        com.baidu.tbadk.core.sharedPref.b.og().putBoolean("game_is_show_tip", false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
        mainTabActivity = this.ccc.cbW;
        mainTabActivity2 = this.ccc.cbW;
        mainTabActivity.sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
    }
}
