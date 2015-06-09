package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aDi;
    private final /* synthetic */ int bbB;
    final /* synthetic */ aj cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(aj ajVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.cwo = ajVar;
        this.aDi = aVar;
        this.bbB = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aDi.dismiss();
        if (this.bbB == 0) {
            mainTabActivity2 = this.cwo.cwi;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.bbB == 1) {
            mainTabActivity = this.cwo.cwi;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
