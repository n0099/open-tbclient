package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aKS;
    private final /* synthetic */ int bpU;
    final /* synthetic */ am cVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(am amVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.cVq = amVar;
        this.aKS = aVar;
        this.bpU = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aKS.dismiss();
        if (this.bpU == 0) {
            mainTabActivity2 = this.cVq.cVl;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.bpU == 1) {
            mainTabActivity = this.cVq.cVl;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
