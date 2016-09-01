package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arh;
    private final /* synthetic */ int cVm;
    final /* synthetic */ ac fwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ac acVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.fwR = acVar;
        this.arh = aVar;
        this.cVm = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.arh.dismiss();
        if (this.cVm == 0) {
            mainTabActivity2 = this.fwR.fwG;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.cVm == 1) {
            mainTabActivity = this.fwR.fwG;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
