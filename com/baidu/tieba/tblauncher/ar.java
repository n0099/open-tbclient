package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arM;
    private final /* synthetic */ int dcr;
    final /* synthetic */ ae fGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ae aeVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.fGW = aeVar;
        this.arM = aVar;
        this.dcr = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.arM.dismiss();
        if (this.dcr == 0) {
            mainTabActivity2 = this.fGW.fGL;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.dcr == 1) {
            mainTabActivity = this.fGW.fGL;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
