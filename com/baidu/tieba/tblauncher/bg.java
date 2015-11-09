package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amr;
    private final /* synthetic */ int btK;
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ao aoVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.dfH = aoVar;
        this.amr = aVar;
        this.btK = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.amr.dismiss();
        if (this.btK == 0) {
            mainTabActivity2 = this.dfH.dfC;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.btK == 1) {
            mainTabActivity = this.dfH.dfC;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
