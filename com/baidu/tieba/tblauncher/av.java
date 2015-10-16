package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ ao ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.ddy = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.ddy.ddt;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        mainTabActivity2 = this.ddy.ddt;
        com.baidu.tbadk.core.util.bd.ag(mainTabActivity2.getPageContext().getPageActivity());
    }
}
