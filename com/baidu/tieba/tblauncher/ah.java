package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqv;
    final /* synthetic */ aa fuh;
    private final /* synthetic */ int val$type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(aa aaVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.fuh = aaVar;
        this.aqv = aVar;
        this.val$type = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aqv.dismiss();
        if (this.val$type == 0) {
            mainTabActivity2 = this.fuh.fua;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.val$type == 1) {
            mainTabActivity = this.fuh.fua;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
