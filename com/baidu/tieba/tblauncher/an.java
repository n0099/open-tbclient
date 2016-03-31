package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqR;
    final /* synthetic */ aa etY;
    private final /* synthetic */ int val$type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aa aaVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.etY = aaVar;
        this.aqR = aVar;
        this.val$type = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aqR.dismiss();
        if (this.val$type == 0) {
            mainTabActivity2 = this.etY.etM;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.val$type == 1) {
            mainTabActivity = this.etY.etM;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
