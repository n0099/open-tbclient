package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.dfH = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.dfH.dfC;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        mainTabActivity2 = this.dfH.dfC;
        com.baidu.tbadk.core.util.bd.ag(mainTabActivity2.getPageContext().getPageActivity());
    }
}
