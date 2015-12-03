package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aoe;
    private final /* synthetic */ int bIP;
    final /* synthetic */ w dDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(w wVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.dDs = wVar;
        this.aoe = aVar;
        this.bIP = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aoe.dismiss();
        if (this.bIP == 0) {
            mainTabActivity2 = this.dDs.dDj;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.bIP == 1) {
            mainTabActivity = this.dDs.dDj;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
