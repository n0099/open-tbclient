package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a anl;
    private final /* synthetic */ int cGS;
    final /* synthetic */ ab fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ab abVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.fbT = abVar;
        this.anl = aVar;
        this.cGS = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.anl.dismiss();
        if (this.cGS == 0) {
            mainTabActivity2 = this.fbT.fbI;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.cGS == 1) {
            mainTabActivity = this.fbT.fbI;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
