package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqS;
    private final /* synthetic */ int cWG;
    final /* synthetic */ ab fzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ab abVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.fzu = abVar;
        this.aqS = aVar;
        this.cWG = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aqS.dismiss();
        if (this.cWG == 0) {
            mainTabActivity2 = this.fzu.fzj;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.cWG == 1) {
            mainTabActivity = this.fzu.fzj;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
