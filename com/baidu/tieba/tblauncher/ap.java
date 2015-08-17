package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ ai cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ai aiVar) {
        this.cMQ = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.cMQ.cMK;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        mainTabActivity2 = this.cMQ.cMK;
        com.baidu.tbadk.core.util.bb.ag(mainTabActivity2.getPageContext().getPageActivity());
    }
}
