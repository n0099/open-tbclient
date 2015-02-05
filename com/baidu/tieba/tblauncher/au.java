package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements d {
    private final /* synthetic */ a aRx;
    private final /* synthetic */ int aTW;
    final /* synthetic */ ai cdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ai aiVar, a aVar, int i) {
        this.cdv = aiVar;
        this.aRx = aVar;
        this.aTW = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.aRx.dismiss();
        if (this.aTW == 0) {
            mainTabActivity2 = this.cdv.cdq;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_overdue_know", "click", 1, new Object[0]);
        } else if (this.aTW == 1) {
            mainTabActivity = this.cdv.cdq;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_know", "click", 1, new Object[0]);
        }
    }
}
