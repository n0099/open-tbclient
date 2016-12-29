package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arp;
    private final /* synthetic */ int cHo;
    final /* synthetic */ ad flb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ad adVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.flb = adVar;
        this.arp = aVar;
        this.cHo = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.arp.dismiss();
        if (this.cHo == 0) {
            mainTabActivity2 = this.flb.fkU;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.cHo == 1) {
            mainTabActivity = this.flb.fkU;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
