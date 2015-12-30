package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ w dKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(w wVar) {
        this.dKW = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.dKW.dKM;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        mainTabActivity2 = this.dKW.dKM;
        bj.ag(mainTabActivity2.getPageContext().getPageActivity());
    }
}
