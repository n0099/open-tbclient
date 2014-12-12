package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int aSL;
    final /* synthetic */ an ccc;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(an anVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.ccc = anVar;
        this.cce = aVar;
        this.aSL = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.cce.dismiss();
        if (this.aSL == 0) {
            mainTabActivity2 = this.ccc.cbW;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.aSL == 1) {
            mainTabActivity = this.ccc.cbW;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
