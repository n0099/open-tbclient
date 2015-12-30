package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a apI;
    private final /* synthetic */ int bMx;
    final /* synthetic */ w dKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(w wVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.dKW = wVar;
        this.apI = aVar;
        this.bMx = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.apI.dismiss();
        if (this.bMx == 0) {
            mainTabActivity2 = this.dKW.dKM;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.bMx == 1) {
            mainTabActivity = this.dKW.dKM;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
