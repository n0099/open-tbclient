package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.g {
    final /* synthetic */ p ciY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.ciY = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        if (obj == null) {
            newUserGuideActivity4 = this.ciY.ciV;
            newUserGuideActivity4.showToast(n.i.neterror);
        } else if (obj instanceof y) {
            int g = com.baidu.adp.lib.h.b.g(((y) obj).getFid(), 0);
            aVar = this.ciY.ciW;
            aVar.jc(g);
            this.ciY.o(g, true);
            newUserGuideActivity = this.ciY.ciV;
            newUserGuideActivity.eh(true);
            newUserGuideActivity2 = this.ciY.ciV;
            newUserGuideActivity2.eg(true);
            newUserGuideActivity3 = this.ciY.ciV;
            TiebaStatic.eventStat(newUserGuideActivity3.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
        }
    }
}
