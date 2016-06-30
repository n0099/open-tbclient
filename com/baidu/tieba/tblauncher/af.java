package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ab fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar) {
        this.fbT = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fbT.fbI;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        mainTabActivity2 = this.fbT.fbI;
        bn.aa(mainTabActivity2.getPageContext().getPageActivity());
    }
}
