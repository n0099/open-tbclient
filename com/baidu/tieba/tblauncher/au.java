package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements d {
    private final /* synthetic */ a aRy;
    private final /* synthetic */ int aTX;
    final /* synthetic */ ai cdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ai aiVar, a aVar, int i) {
        this.cdw = aiVar;
        this.aRy = aVar;
        this.aTX = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aRy.dismiss();
        if (this.aTX == 0) {
            mainTabActivity2 = this.cdw.cdr;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.aTX == 1) {
            mainTabActivity = this.cdw.cdr;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
