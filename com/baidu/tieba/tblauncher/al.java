package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ z fyG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(z zVar) {
        this.fyG = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fyG.fyz;
        TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
        mainTabActivity2 = this.fyG.fyz;
        bg.aH(mainTabActivity2.getPageContext().getPageActivity());
    }
}
