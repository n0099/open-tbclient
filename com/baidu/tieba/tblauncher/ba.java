package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aKF;
    private final /* synthetic */ int bpw;
    final /* synthetic */ ai cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ai aiVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.cMQ = aiVar;
        this.aKF = aVar;
        this.bpw = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aKF.dismiss();
        if (this.bpw == 0) {
            mainTabActivity2 = this.cMQ.cMK;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.bpw == 1) {
            mainTabActivity = this.cMQ.cMK;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
