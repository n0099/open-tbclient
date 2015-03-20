package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBl;
    private final /* synthetic */ int aYD;
    final /* synthetic */ ai crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ai aiVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.crN = aiVar;
        this.aBl = aVar;
        this.aYD = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aBl.dismiss();
        if (this.aYD == 0) {
            mainTabActivity2 = this.crN.crH;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.aYD == 1) {
            mainTabActivity = this.crN.crH;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
