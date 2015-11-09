package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ao aoVar) {
        this.dfH = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.dfH.dfC;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
        mainTabActivity2 = this.dfH.dfC;
        com.baidu.tbadk.core.util.bd.af(mainTabActivity2.getPageContext().getPageActivity());
    }
}
