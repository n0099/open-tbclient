package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aDh;
    private final /* synthetic */ int bbA;
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(aj ajVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.cwn = ajVar;
        this.aDh = aVar;
        this.bbA = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aDh.dismiss();
        if (this.bbA == 0) {
            mainTabActivity2 = this.cwn.cwh;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.bbA == 1) {
            mainTabActivity = this.cwn.cwh;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
