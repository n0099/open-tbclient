package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amF;
    private final /* synthetic */ int cbw;
    final /* synthetic */ ab exg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ab abVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.exg = abVar;
        this.amF = aVar;
        this.cbw = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.amF.dismiss();
        if (this.cbw == 0) {
            mainTabActivity2 = this.exg.ewR;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.cbw == 1) {
            mainTabActivity = this.exg.ewR;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
