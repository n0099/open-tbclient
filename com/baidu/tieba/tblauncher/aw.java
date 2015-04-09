package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBt;
    private final /* synthetic */ int aYT;
    final /* synthetic */ ai csd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ai aiVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.csd = aiVar;
        this.aBt = aVar;
        this.aYT = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aBt.dismiss();
        if (this.aYT == 0) {
            mainTabActivity2 = this.csd.crX;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.aYT == 1) {
            mainTabActivity = this.csd.crX;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
